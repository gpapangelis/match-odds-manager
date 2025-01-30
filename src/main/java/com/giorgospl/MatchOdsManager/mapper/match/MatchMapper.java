package com.giorgospl.MatchOdsManager.mapper.match;

import com.giorgospl.MatchOdsManager.model.enums.Sport;
import com.giorgospl.MatchOdsManager.model.rest.match.CreateMatchRequest;
import com.giorgospl.MatchOdsManager.model.rest.match.GetMatchByIdResponse;
import com.giorgospl.MatchOdsManager.model.rest.match.GetMatchByIdResponseItem;
import com.giorgospl.MatchOdsManager.model.rest.match.GetMatchesResponseItem;
import com.giorgospl.MatchOdsManager.persistance.entity.MatchEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MatchMapper {

    public GetMatchesResponseItem matchEntityToGetMatchesResponseItem(MatchEntity matchEntity){
        return GetMatchesResponseItem.builder()
                .matchId(matchEntity.getMatchId())
                .description(matchEntity.getDescription())
                .matchDate(matchEntity.getDate())
                .matchTime(matchEntity.getTime())
                .firstTeam(matchEntity.getFirstTeam())
                .secondTeam(matchEntity.getSecondTeam())
                .sport(Sport.getFromValue(matchEntity.getSport()))
                .dateCreated(matchEntity.getDateCreated())
                .dateUpdated(matchEntity.getDateUpdated())
                .build();
    }

    public MatchEntity createMatchRequestToMatchEntity(CreateMatchRequest createMatchRequest){
        return MatchEntity.builder()
                .matchId(UUID.randomUUID().toString())
                .description(createMatchRequest.getDescription())
                .date(createMatchRequest.getMatchDate())
                .time(createMatchRequest.getMatchTime())
                .firstTeam(createMatchRequest.getFirstTeam())
                .secondTeam(createMatchRequest.getSecondTeam())
                .sport(createMatchRequest.getSport().getCode())
                .build();
    }

    public GetMatchByIdResponse matchEntityToGetMatchByIdResponse(MatchEntity matchEntity, List<GetMatchByIdResponseItem> getMatchByIdResponseItemList){
        return GetMatchByIdResponse.builder()
                .matchId(matchEntity.getMatchId())
                .description(matchEntity.getDescription())
                .matchDate(matchEntity.getDate())
                .matchTime(matchEntity.getTime())
                .firstTeam(matchEntity.getFirstTeam())
                .secondTeam(matchEntity.getSecondTeam())
                .sport(Sport.getFromValue(matchEntity.getSport()))
                .dateCreated(matchEntity.getDateCreated())
                .dateUpdated(matchEntity.getDateUpdated())
                .odds(getMatchByIdResponseItemList)
                .build();
    }
}
