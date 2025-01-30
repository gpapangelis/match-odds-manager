package com.giorgospl.MatchOdsManager.service.matchodd;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.GetMatchOddsResponse;

public interface GetMatchOddsService {
    GetMatchOddsResponse getMatchOdds(String matchId, String requestId) throws CustomException;
}
