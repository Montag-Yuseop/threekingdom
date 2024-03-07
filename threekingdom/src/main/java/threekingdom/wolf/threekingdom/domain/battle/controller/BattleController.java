package threekingdom.wolf.threekingdom.domain.battle.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import threekingdom.wolf.threekingdom.domain.battle.dto.request.CreateBattleReqDto;
import threekingdom.wolf.threekingdom.domain.battle.dto.response.BattleResDto;
import threekingdom.wolf.threekingdom.domain.battle.service.BattleService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/battles")
public class BattleController {

    private final BattleService battleService;

    // 전적 생성 또는 수정
    @PostMapping
    public ResponseEntity<String> createBattle(@Valid @RequestBody CreateBattleReqDto createBattleReqDto) {

        String result = battleService.createBattle(createBattleReqDto);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 전적 조회
    @GetMapping
    public ResponseEntity<BattleResDto> searchBattle(@Valid @RequestParam Long myDeckId, @Valid @RequestParam Long enemyDeckId) {

        BattleResDto battleResDto = battleService.searchBattle(myDeckId, enemyDeckId);
        return ResponseEntity.status(HttpStatus.OK).body(battleResDto);
    }

    // 전적 삭제
    @DeleteMapping
    public ResponseEntity<String> deleteBattle(@Valid @RequestParam Long battleId) {

        String result = battleService.deleteBattle(battleId);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}