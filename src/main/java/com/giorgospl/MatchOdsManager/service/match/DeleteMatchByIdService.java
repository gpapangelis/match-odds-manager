package com.giorgospl.MatchOdsManager.service.match;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.model.Result;

public interface DeleteMatchByIdService {
    Result deleteMatchById(String matchId, String requestId) throws CustomException;
}
