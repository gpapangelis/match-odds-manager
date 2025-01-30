package com.giorgospl.MatchOdsManager.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomException extends Exception{
    private String requestId;
    private Integer errorCode;
    private String errorMessage;
}
