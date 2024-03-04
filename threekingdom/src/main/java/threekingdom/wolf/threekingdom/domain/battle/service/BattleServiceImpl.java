package threekingdom.wolf.threekingdom.domain.battle.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import threekingdom.wolf.threekingdom.domain.battle.dto.request.CreateBattleReqDto;
import threekingdom.wolf.threekingdom.domain.battle.dto.response.BattleResDto;
import threekingdom.wolf.threekingdom.domain.battle.entity.Battle;
import threekingdom.wolf.threekingdom.domain.battle.repository.BattleRepository;
import threekingdom.wolf.threekingdom.domain.deck.entity.Deck;
import threekingdom.wolf.threekingdom.domain.deck.repository.DeckRepository;
import threekingdom.wolf.threekingdom.global.error.ErrorCode;
import threekingdom.wolf.threekingdom.global.error.exception.BattleException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class BattleServiceImpl implements BattleService {
    private final DeckRepository deckRepository;
    private final BattleRepository battleRepository;

    @Override
    @Transactional
    public String createBattle(CreateBattleReqDto createBattleReqDto) {
        Optional<Deck> myDeck = deckRepository.findByDeckId(createBattleReqDto.getMyDeckId());
        Optional<Deck> enemyDeck = deckRepository.findByDeckId(createBattleReqDto.getEnemyDeckId());

        if(myDeck.isEmpty()) {
            throw new BattleException(ErrorCode.NO_EXIST_MY_DECK);
        }

        if(enemyDeck.isEmpty()) {
            throw new BattleException(ErrorCode.NO_EXIST_ENEMY_DECK);
        }

        Deck getMyDeck = myDeck.get();
        Deck getEnemyDeck = enemyDeck.get();

        Optional<Battle> battle =  battleRepository.findByMyDeckAndEnemyDeck(getMyDeck, getEnemyDeck);
        // 전적 결과가 있으면
        if (battle.isPresent()) {
            // 기존 배틀 결과를 가져와서 승리 여부만 넘긴다
            Battle getBattle = battle.get();
            getBattle.update(createBattleReqDto.getIsWin());
        } else { // 없으면 생성
            if(createBattleReqDto.getIsWin()) battleRepository.save(Battle.from(getMyDeck, getEnemyDeck, 1));
            else battleRepository.save(Battle.from(getMyDeck, getEnemyDeck, 0));
        }

        return "success";
    }

    @Override
    public BattleResDto searchBattle(Long myDeckId, Long enemyDeckId) {
        Optional<Deck> myDeck = deckRepository.findByDeckId(myDeckId);
        Optional<Deck> enemyDeck = deckRepository.findByDeckId(enemyDeckId);

        if(myDeckId == enemyDeckId) {
            throw new BattleException(ErrorCode.DECK_ID_IS_SAME);
        }

        if(myDeck.isEmpty()) {
            throw new BattleException(ErrorCode.NO_EXIST_MY_DECK);
        }

        if(enemyDeck.isEmpty()) {
            throw new BattleException(ErrorCode.NO_EXIST_ENEMY_DECK);
        }

        Deck getMyDeck = myDeck.get();
        Deck getEnemyDeck = enemyDeck.get();

        Optional<Battle> battle = battleRepository.findByMyDeckAndEnemyDeck(getMyDeck, getEnemyDeck);
        if(battle.isEmpty()) {
            throw new BattleException(ErrorCode.NO_EXIST_BATTLE_HISTORY);
        }

        Battle getBattle = battle.get();
        double base = (double) getBattle.getWinCount() / getBattle.getBattleCount();
        BattleResDto battleResDto = BattleResDto.of(getBattle.getBattleId(), getBattle.getBattleCount(), getBattle.getWinCount(), Math.round(base * 100));

        return battleResDto;
    }

    @Override
    @Transactional
    public String deleteBattle(Long battleId) {

        Optional<Battle> battle = battleRepository.findById(battleId);

        if(battle.isEmpty()) {
            throw new BattleException(ErrorCode.NO_EXIST_BATTLE_HISTORY);
        }

        Battle getBattle = battle.get();
        battleRepository.delete(getBattle);

        return "success";
    }
}
