package threekingdom.wolf.threekingdom.global.entity;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SeasonCode {

    SEASON1(1, "시즌1"),
    SEASON2(2, "시즌2"),
    SEASON3(3, "시즌3"),
    SEASON4(4, "군웅할거"),
    SEASON5(5, "천하쟁패"),
    SEASON6(6, "적벽대전"),
    SEASON7(7, "군쟁지리"),
    SEASON8(8, "흥사벌란"),
    SEASON9(9, "북정중원"),
    SEASON10(10, "관도대전"),
    SEASON11(11, "왕사병절"),
    SEASON12(12, "영웅집결"),
    SEASON13(13, "병전사시"),
    SEASON14(14, "양번대전"),

    ;


    SeasonCode(int seasonNum, String seasonName) {
        this.seasonNum = seasonNum;
        this.seasonName = seasonName;
    }

    private int seasonNum;
    private String seasonName;
}
