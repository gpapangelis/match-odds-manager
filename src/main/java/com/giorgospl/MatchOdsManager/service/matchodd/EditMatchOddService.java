package com.giorgospl.MatchOdsManager.service.matchodd;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.model.Result;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.EditMatchOddRequest;
import jakarta.validation.Valid;

public interface EditMatchOddService {
    Result editMatchOdd(@Valid EditMatchOddRequest request, String requestId) throws CustomException;
}
