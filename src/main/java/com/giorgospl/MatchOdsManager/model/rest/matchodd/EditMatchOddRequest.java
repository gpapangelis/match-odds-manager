package com.giorgospl.MatchOdsManager.model.rest.matchodd;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditMatchOddRequest {
    @NotBlank
    private String matchId;
    @NotBlank
    private String oddId;
    private String specifier;
    private BigDecimal odd;
}
