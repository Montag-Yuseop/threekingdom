package threekingdom.wolf.threekingdom.domain.deck.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import threekingdom.wolf.threekingdom.domain.deck.dto.request.CreateDeckReqDto;
import threekingdom.wolf.threekingdom.domain.deck.dto.response.SearchDeckResDto;
import threekingdom.wolf.threekingdom.domain.deck.service.DeckService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/decks")
public class DeckController {

    private final DeckService deckService;

    // 덱 등록
    @PostMapping
    public ResponseEntity<String> createDeck(@Valid @RequestBody CreateDeckReqDto createDeckReqDto) {

        String result = deckService.createDeck(createDeckReqDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 덱 조회
    @GetMapping
    public ResponseEntity<SearchDeckResDto> searchDeck(@Valid @RequestParam(value = "user_id") Long userId,
                                                       @Valid @RequestParam(value = "season_num") int seasonNum
                                                       ) {

        SearchDeckResDto searchDeckResDto = deckService.search(userId, seasonNum);
        return ResponseEntity.status(HttpStatus.OK).body(searchDeckResDto);
    }

    // 덱 수정

    // 덱 삭제
}
