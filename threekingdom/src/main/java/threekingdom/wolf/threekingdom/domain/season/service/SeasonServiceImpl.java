package threekingdom.wolf.threekingdom.domain.season.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import threekingdom.wolf.threekingdom.domain.season.dto.request.SeasonReqDto;
import threekingdom.wolf.threekingdom.domain.season.dto.response.SeasonListResDto;
import threekingdom.wolf.threekingdom.domain.season.dto.response.SeasonResDto;
import threekingdom.wolf.threekingdom.domain.season.entity.Season;
import threekingdom.wolf.threekingdom.domain.season.repository.SeasonRepository;
import threekingdom.wolf.threekingdom.domain.user.entity.User;
import threekingdom.wolf.threekingdom.domain.user.repository.UserRepository;
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

        List<Season> seasonList = seasonRepository.findAllByUser(getUser);

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
    public String join(SeasonReqDto seasonReqDto) {

        int seasonNum = seasonReqDto.getSeasonNum();



        return "Success";
    }
}
