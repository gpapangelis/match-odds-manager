package com.giorgospl.MatchOdsManager.model.rest.matchodd;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteMatchOddRequest {
    @NotBlank
    private String matchId;
    @NotBlank
    private String oddId;
}
