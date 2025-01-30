package com.giorgospl.MatchOdsManager.mapper.matchodd;

import com.giorgospl.MatchOdsManager.model.rest.match.GetMatchByIdResponseItem;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.CreateMatchOddsRequest;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.CreateMatchOddsRequestItem;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.GetMatchOddsResponseItem;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.GetOddsResponseItem;
import com.giorgospl.MatchOdsManager.persistance.entity.MatchEntity;
import com.giorgospl.MatchOdsManager.persistance.entity.MatchOddEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MatchOddMapper {

    public GetMatchByIdResponseItem oddEntityToGetMatchByIdResponseItem(MatchOddEntity matchOddEntity){
        return GetMatchByIdResponseItem.builder()
                .oddId(matchOddEntity.getOddId())
                .specifier(matchOddEntity.getSpecifier())
                .odd(matchOddEntity.getOdd())
                .dateCreated(matchOddEntity.getDateCreated())
                .dateUpdated(matchOddEntity.getDateUpdated())
                .build();
    }

    public GetOddsResponseItem oddEntityToGetOddsResponseItem(MatchOddEntity matchOddEntity){
        return GetOddsResponseItem.builder()
                .oddId(matchOddEntity.getOddId())
                .specifier(matchOddEntity.getSpecifier())
                .odd(matchOddEntity.getOdd())
                .matchId(matchOddEntity.getMatch() != null ? matchOddEntity.getMatch().getMatchId() : null)
                .dateCreated(matchOddEntity.getDateCreated())
                .dateUpdated(matchOddEntity.getDateUpdated())
                .build();
    }

    public GetMatchOddsResponseItem matchOddEntityToGetMatchOddsResponseItem(MatchOddEntity matchOddEntity){
        return GetMatchOddsResponseItem.builder()
                .oddId(matchOddEntity.getOddId())
                .specifier(matchOddEntity.getSpecifier())
                .odd(matchOddEntity.getOdd())
                .dateCreated(matchOddEntity.getDateCreated())
                .dateUpdated(matchOddEntity.getDateUpdated())
                .build();
    }

    public MatchOddEntity createMatchOddsRequestToMatchOddEntity(CreateMatchOddsRequestItem createMatchOddsRequestItem, MatchEntity matchEntity){
        return MatchOddEntity.builder()
                .oddId(UUID.randomUUID().toString())
                .specifier(createMatchOddsRequestItem.getSpecifier())
                .odd(createMatchOddsRequestItem.getOdd())
                .match(matchEntity)
                .build();
    }
}
