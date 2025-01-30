package com.giorgospl.MatchOdsManager.model.rest.match;

import com.giorgospl.MatchOdsManager.model.enums.Sport;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMatchRequest {
    @NotBlank
    private String description;
    private LocalDate matchDate;
    private LocalTime matchTime;
    @NotBlank
    private String firstTeam;
    @NotBlank
    private String secondTeam;
    private Sport sport;
}
