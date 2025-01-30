package com.giorgospl.MatchOdsManager.model.rest.matchodd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMatchOddsRequestItem {
    private String specifier;
    private BigDecimal odd;
}
