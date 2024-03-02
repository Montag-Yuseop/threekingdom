package threekingdom.wolf.threekingdom.domain.deck.service;

import threekingdom.wolf.threekingdom.domain.deck.dto.request.CreateDeckReqDto;
import threekingdom.wolf.threekingdom.domain.deck.dto.response.SearchDeckResDto;

public interface DeckService {

    public String createDeck(CreateDeckReqDto createDeckReqDto);

    public SearchDeckResDto search(Long userId, int seasonNum);
}
