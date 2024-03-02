package threekingdom.wolf.threekingdom.domain.season.service;

import threekingdom.wolf.threekingdom.domain.season.dto.request.SeasonReqDto;
import threekingdom.wolf.threekingdom.domain.season.dto.response.SeasonListResDto;
import threekingdom.wolf.threekingdom.domain.season.dto.response.SeasonResDto;

import java.util.List;

public interface SeasonService {

    SeasonListResDto getSeasons(Long userId);

    String join(SeasonReqDto seasonReqDto);
}
