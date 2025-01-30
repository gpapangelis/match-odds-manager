package com.giorgospl.MatchOdsManager.service.matchodd;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.CreateMatchOddsRequest;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.CreateMatchOddsResponse;
import jakarta.validation.Valid;

public interface CreateMatchOddsService {
    CreateMatchOddsResponse createMatchOdds(@Valid CreateMatchOddsRequest request, String requestId) throws CustomException;
}
