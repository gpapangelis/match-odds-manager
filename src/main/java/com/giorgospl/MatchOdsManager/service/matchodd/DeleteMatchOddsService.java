package com.giorgospl.MatchOdsManager.service.matchodd;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.model.Result;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.DeleteMatchOddRequest;
import jakarta.validation.Valid;

public interface DeleteMatchOddsService {
    Result deleteMatchOdds(@Valid DeleteMatchOddRequest request, String requestId) throws CustomException;
}
