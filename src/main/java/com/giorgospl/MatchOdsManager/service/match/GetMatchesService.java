package com.giorgospl.MatchOdsManager.service.match;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.model.rest.match.GetMatchesResponse;

public interface GetMatchesService {
    GetMatchesResponse getMatches(String requestId) throws CustomException;
}
