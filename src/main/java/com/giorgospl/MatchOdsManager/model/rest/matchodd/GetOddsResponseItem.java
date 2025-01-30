package com.giorgospl.MatchOdsManager.model.rest.matchodd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetOddsResponseItem {
    private String oddId;
    private String specifier;
    private BigDecimal odd;
    private String matchId;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
