package threekingdom.wolf.threekingdom.domain.battle.service;

import threekingdom.wolf.threekingdom.domain.battle.dto.request.CreateBattleReqDto;
import threekingdom.wolf.threekingdom.domain.battle.dto.response.BattleResDto;

public interface BattleService {

    String createBattle(CreateBattleReqDto createBattleReqDto);

    BattleResDto searchBattle(Long myDeckId, Long enemyDeckId);

    String deleteBattle(Long battleId);
}
