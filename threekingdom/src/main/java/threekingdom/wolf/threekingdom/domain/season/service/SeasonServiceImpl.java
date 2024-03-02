package threekingdom.wolf.threekingdom.domain.season.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import threekingdom.wolf.threekingdom.domain.season.dto.request.CreateSeasonReqDto;
import threekingdom.wolf.threekingdom.domain.season.dto.response.SeasonListResDto;
import threekingdom.wolf.threekingdom.domain.season.dto.response.SeasonResDto;
import threekingdom.wolf.threekingdom.domain.season.entity.Season;
import threekingdom.wolf.threekingdom.domain.season.repository.SeasonRepository;
import threekingdom.wolf.threekingdom.domain.user.entity.User;
import threekingdom.wolf.threekingdom.domain.user.repository.UserRepository;
import threekingdom.wolf.threekingdom.global.entity.SeasonCode;
import threekingdom.wolf.threekingdom.global.error.ErrorCode;
import threekingdom.wolf.threekingdom.global.error.exception.SeasonException;
import threekingdom.wolf.threekingdom.global.error.exception.UserException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SeasonServiceImpl implements SeasonService {

    private final SeasonRepository seasonRepository;
    private final UserRepository userRepository;

    @Override
    public SeasonListResDto getSeasons(Long userId) {

        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            throw new UserException(ErrorCode.NO_SEARCH_USERS);
        }

        User getUser = user.get();

        List<Season> seasonList = seasonRepository.findAllByUserOrderBySeasonNumAsc(getUser);

        if(seasonList.isEmpty()) {
            // 나중에 시즌 없으면 처리
            throw new SeasonException(ErrorCode.NO_EXIST_SEASON);
        }

        List<SeasonResDto> seasonResDtos = new ArrayList<>();

        for (Season season : seasonList) {
            seasonResDtos.add(
                    SeasonResDto.from(season)
            );
        }

        return SeasonListResDto.from(seasonResDtos);
    }

    @Override
    public String join(CreateSeasonReqDto createSeasonReqDto) {

        // SeasonNum과 UserId를 받아서 새로운 시즌을 저장한다
        int seasonNum = createSeasonReqDto.getSeasonNum();
        Long userId = createSeasonReqDto.getUserId();
        Optional<User> user = userRepository.findById(userId);
        User getUser = user.get();

        if(user.isEmpty()) {
            throw new UserException(ErrorCode.NO_SEARCH_USERS);
        }

        // 해당 유저의 season이 이미 존재하면 오류를 출력한다.
        List<Season> seasons = getUser.getSeasons();
        for(Season season : seasons) {
            if(season.getSeasonNum() == seasonNum) {
                throw new SeasonException(ErrorCode.ALREADY_EXIST_SEASON);
            }
        }


        Season season = Season.from(getUser, seasonNum, SeasonCode.getSeasonName(seasonNum));

        seasonRepository.save(season);

        return "Success";
    }
}
