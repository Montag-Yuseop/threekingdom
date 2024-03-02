package threekingdom.wolf.threekingdom.domain.season.service;

import threekingdom.wolf.threekingdom.domain.season.dto.request.CreateSeasonReqDto;
import threekingdom.wolf.threekingdom.domain.season.dto.response.SeasonListResDto;

public interface SeasonService {

    SeasonListResDto getSeasons(Long userId);

    String join(CreateSeasonReqDto seasonReqDto);
}
