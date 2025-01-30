package com.giorgospl.MatchOdsManager.service.matchodd;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.GetOddsResponse;

public interface GetOddsService {
    GetOddsResponse getOdds(String requestId) throws CustomException;
}
