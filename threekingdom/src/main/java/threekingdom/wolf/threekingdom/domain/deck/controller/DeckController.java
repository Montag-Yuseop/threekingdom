package threekingdom.wolf.threekingdom.domain.deck.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import threekingdom.wolf.threekingdom.domain.deck.dto.request.CreateDeckReqDto;
import threekingdom.wolf.threekingdom.domain.deck.dto.request.ModifyDeckReqDto;
import threekingdom.wolf.threekingdom.domain.deck.dto.response.SearchDeckResDto;
import threekingdom.wolf.threekingdom.domain.deck.service.DeckService;

import java.util.List;

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
    public ResponseEntity<List<SearchDeckResDto>> searchDeck(@Valid @RequestParam(value = "user_id") Long userId,
                                                            @Valid @RequestParam(value = "season_num") int seasonNum
                                                       ) {

        List<SearchDeckResDto> searchDeckResDto = deckService.searchDeck(userId, seasonNum);
        return ResponseEntity.status(HttpStatus.OK).body(searchDeckResDto);
    }

    // 덱 수정
    @PatchMapping
    public ResponseEntity<String> modify(@Valid @RequestBody ModifyDeckReqDto modifyDeckReqDto) {

        // deckId와 변경된 정보를 받아서 수정한다
        String result = deckService.modifyDeck(modifyDeckReqDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 덱 삭제
    @DeleteMapping
    public ResponseEntity<String> delete(@Valid @RequestParam Long deckId) {

        String result = deckService.deleteDeck(deckId);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
