package com.giorgospl.MatchOdsManager.model.rest.matchodd;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMatchOddsRequest {
    @NotBlank
    private String matchId;
    @NotEmpty
    private List<CreateMatchOddsRequestItem> odds;
}
