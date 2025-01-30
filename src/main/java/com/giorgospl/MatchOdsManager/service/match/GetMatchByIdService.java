package com.giorgospl.MatchOdsManager.service.match;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.model.rest.match.GetMatchByIdResponse;

public interface GetMatchByIdService {
    GetMatchByIdResponse getMatchById(String matchId, String requestId) throws CustomException;
}
