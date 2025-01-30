package com.giorgospl.MatchOdsManager.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    CODE_1(1,"Bad request"),
    CODE_2(2,"internal error"),
    CODE_3(3,"No matches found"),
    CODE_4(4,"No match found for the requested matchId"),
    CODE_5(5,"No odds found"),
    CODE_6(6,"No odd found for the requested matchId and oddId");

    private Integer code;
    private String description;
}
