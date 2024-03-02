package threekingdom.wolf.threekingdom.domain.season.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import threekingdom.wolf.threekingdom.domain.season.dto.request.CreateSeasonReqDto;
import threekingdom.wolf.threekingdom.domain.season.dto.response.SeasonListResDto;
import threekingdom.wolf.threekingdom.domain.season.service.SeasonService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seasons")
public class SeasonController {

    private final SeasonService seasonService;

    @PostMapping
    public ResponseEntity<String> createSeason(@Valid @RequestBody CreateSeasonReqDto createSeasonReqDto) {

        String result = seasonService.join(createSeasonReqDto);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<SeasonListResDto> getSeason(@Valid @PathVariable Long userId) {


        SeasonListResDto result = seasonService.getSeasons(userId);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
