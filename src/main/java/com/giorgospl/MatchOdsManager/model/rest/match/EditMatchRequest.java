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
public class EditMatchRequest {
    @NotBlank
    private String matchId;
    private String description;
    private LocalDate matchDate;
    private LocalTime matchTime;
    private String firstTeam;
    private String secondTeam;
    private Sport sport;
}
