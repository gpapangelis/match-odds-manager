package com.giorgospl.MatchOdsManager.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sport {
    FOOTBALL(1),
    BASKETBALL(2);

    private final Integer code;

    //TODO revisit this method for fixes
    @JsonCreator
    public static Sport fromValue(String value) {
        for (Sport sport : values()) {
            if (sport.name().equalsIgnoreCase(value)) {
                return sport;
            }
        }
        throw new IllegalArgumentException("Invalid sport value: " + value);
    }

    public static Sport getFromValue(Integer code){
        for (Sport sport : values()) {
            if (sport.getCode().equals(code)){
                return sport;
            }
        }
        throw new IllegalArgumentException("Invalid code for Sport: " + code);
    }
}
