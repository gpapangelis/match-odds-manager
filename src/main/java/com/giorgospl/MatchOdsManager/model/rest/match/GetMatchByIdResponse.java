package com.giorgospl.MatchOdsManager.model.rest.match;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.giorgospl.MatchOdsManager.model.Result;
import com.giorgospl.MatchOdsManager.model.enums.Sport;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetMatchByIdResponse extends Result {
    private String matchId;
    private String description;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate matchDate;
    private LocalTime matchTime;
    private String firstTeam;
    private String secondTeam;
    private Sport sport;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private List<GetMatchByIdResponseItem> odds;
}
