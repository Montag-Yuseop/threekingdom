package threekingdom.wolf.threekingdom.domain.deck.service;

import threekingdom.wolf.threekingdom.domain.deck.dto.request.CreateDeckReqDto;
import threekingdom.wolf.threekingdom.domain.deck.dto.request.ModifyDeckReqDto;
import threekingdom.wolf.threekingdom.domain.deck.dto.response.SearchDeckResDto;

import java.util.List;

public interface DeckService {

    String createDeck(CreateDeckReqDto createDeckReqDto);

    List<SearchDeckResDto> searchDeck(Long userId, int seasonNum);

    String modifyDeck(ModifyDeckReqDto modifyDeckReqDto);

    String deleteDeck(Long deckId);
}
