package threekingdom.wolf.threekingdom.domain.deck.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import threekingdom.wolf.threekingdom.domain.deck.dto.request.CreateDeckReqDto;
import threekingdom.wolf.threekingdom.domain.deck.dto.response.SearchDeckResDto;
import threekingdom.wolf.threekingdom.domain.deck.entity.Deck;
import threekingdom.wolf.threekingdom.domain.deck.repository.DeckRepository;
import threekingdom.wolf.threekingdom.domain.hero.dto.request.CreateHeroReqDto;
import threekingdom.wolf.threekingdom.domain.hero.dto.response.HeroResDto;
import threekingdom.wolf.threekingdom.domain.hero.entity.Hero;
import threekingdom.wolf.threekingdom.domain.hero.repository.HeroRepository;
import threekingdom.wolf.threekingdom.domain.item.dto.reqeust.CreateItemReqDto;
import threekingdom.wolf.threekingdom.domain.item.dto.response.ItemResDto;
import threekingdom.wolf.threekingdom.domain.item.entity.Item;
import threekingdom.wolf.threekingdom.domain.item.repository.ItemRepository;
import threekingdom.wolf.threekingdom.domain.season.entity.Season;
import threekingdom.wolf.threekingdom.domain.season.repository.SeasonRepository;
import threekingdom.wolf.threekingdom.domain.skill.dto.request.CreateSkillReqDto;
import threekingdom.wolf.threekingdom.domain.skill.dto.response.SkillResDto;
import threekingdom.wolf.threekingdom.domain.skill.entity.Skill;
import threekingdom.wolf.threekingdom.domain.skill.repository.SkillRepository;
import threekingdom.wolf.threekingdom.domain.user.entity.User;
import threekingdom.wolf.threekingdom.domain.user.repository.UserRepository;
import threekingdom.wolf.threekingdom.global.error.ErrorCode;
import threekingdom.wolf.threekingdom.global.error.exception.DeckException;
import threekingdom.wolf.threekingdom.global.error.exception.SeasonException;
import threekingdom.wolf.threekingdom.global.error.exception.UserException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeckServiceImpl implements DeckService {

    private final UserRepository userRepository;
    private final SeasonRepository seasonRepository;
    private final DeckRepository deckRepository;
    private final HeroRepository heroRepository;
    private final ItemRepository itemRepository;
    private final SkillRepository skillRepository;

    @Override
    @Transactional
    public String createDeck(CreateDeckReqDto createDeckReqDto) {
        // 시즌을 가져온다
        Optional<Season> season = seasonRepository.findBySeasonNum(createDeckReqDto.getSeasonNum());

        // 해당 유저에게 그 시즌이 없다면 오류 반환
        if(season.isEmpty()) {
            throw new SeasonException(ErrorCode.NO_EXIST_SEASON);
        }

        Season getSeason = season.get();

        // 가져온 시즌으로 덱 생성 - 매번 새로운 덱이 생성될 것
        Deck deck = deckRepository.save(Deck.from(getSeason));

        List<CreateHeroReqDto> heroList = createDeckReqDto.getHeroList();
        // 저장된 영웅 정보가 없다면 오류 반환
        if(heroList.isEmpty()) {
            throw new DeckException(ErrorCode.NO_EXIST_HERO);
        }

        for (CreateHeroReqDto createHeroReqDto : heroList) {
            // 장수를 저장
            Hero hero = Hero.from(deck, createHeroReqDto.getHeroName(), createHeroReqDto.getHeroUpgrade(), createHeroReqDto.getHeroLevel());
            Hero save = heroRepository.save(hero);

            // 장수의 아이템 저장
            List<CreateItemReqDto> itemList = createHeroReqDto.getItemList();
            for (CreateItemReqDto createItemReqDto : itemList) {
                Item item = Item.from(save, createItemReqDto.getItemSkill());
                itemRepository.save(item);
            }

            // 장수의 스킬 저장
            List<CreateSkillReqDto> skillList = createHeroReqDto.getSkillList();

            for (CreateSkillReqDto createSkillReqDto : skillList) {
                Skill skill = Skill.from(save, createSkillReqDto.getSkillName(), createSkillReqDto.getSkillLevel());
                skillRepository.save(skill);
            }
        }

        return "success";
    }

    @Override
    public SearchDeckResDto search(Long userId, int seasonNum) {
        
        // 유저 아이디와 시즌 숫자로 덱 리스트를 가져온다
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            throw new UserException(ErrorCode.NO_SEARCH_USERS);
        }

        User getUser = user.get();
        // 유저로부터 해당 시즌 id를 가져온다
        Optional<Season> season = seasonRepository.findAllByUserAndSeasonNum(getUser, seasonNum);

        if(season.isEmpty()) {
            throw new SeasonException(ErrorCode.NO_EXIST_SEASON);
        }

        Season getSeason = season.get();

        // 시즌을 가져온걸로 덱 리스트를 출력한다
        List<Deck> deckList = deckRepository.findAllBySeason(getSeason);

        if(deckList.isEmpty()) {
            throw new DeckException(ErrorCode.NO_EXIST_DECK);
        }

//        List<Deck> deckList = seasonRepository.findAllByUserAndSeasonNum(getUser, seasonNum);
        List<HeroResDto> heroResDtoList = new ArrayList<>();
        // 덱 리스트에서 필요한 정보들을 SearchDeckResDto로 변경한다
        for (Deck deck : deckList) {
            List<Hero> heroes = deck.getHeroes();
            for (Hero hero : heroes) {
                // 아이템 담기
                List<Item> items = hero.getItems();
                List<ItemResDto> itemResDtoList = new ArrayList<>();

                for (Item item : items) {
                    ItemResDto itemResDto = ItemResDto.of(item.getItemSkill());
                    itemResDtoList.add(itemResDto);
                }

                // 스킬 담기
                List<Skill> skills = hero.getSkills();
                List<SkillResDto> skillResDtoList = new ArrayList<>();

                for (Skill skill : skills) {
                    SkillResDto skillResDto = SkillResDto.of(skill.getSkillName(), skill.getSkillLevel());
                    skillResDtoList.add(skillResDto);
                }

                HeroResDto heroResDto = HeroResDto.of(
                        hero.getHeroName(), hero.getHeroLevel(), hero.getHeroUpgrade(), itemResDtoList, skillResDtoList
                );

                heroResDtoList.add(heroResDto);
            }


        }

        // 넘겨준다
        return SearchDeckResDto.of(heroResDtoList);
    }
}
