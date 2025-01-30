package com.giorgospl.MatchOdsManager.service.match;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.model.rest.match.CreateMatchRequest;
import com.giorgospl.MatchOdsManager.model.rest.match.CreateMatchResponse;

public interface CreateMatchService {
    CreateMatchResponse createMatch(CreateMatchRequest request, String requestId) throws CustomException;
}
