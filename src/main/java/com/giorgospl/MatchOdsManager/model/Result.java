package com.giorgospl.MatchOdsManager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    @JsonProperty("errorMessage")
    private String errorMessage;
    @JsonProperty("success")
    private Boolean success = true;
    @JsonProperty("errorLevel")
    private Integer errorLevel = 0;
    @JsonProperty("errorCode")
    private Integer errorCode;
}
