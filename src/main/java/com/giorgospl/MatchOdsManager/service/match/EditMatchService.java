package com.giorgospl.MatchOdsManager.service.match;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.model.Result;
import com.giorgospl.MatchOdsManager.model.rest.match.EditMatchRequest;

public interface EditMatchService {
    Result editMatchService(EditMatchRequest request, String requestId) throws CustomException;
}
