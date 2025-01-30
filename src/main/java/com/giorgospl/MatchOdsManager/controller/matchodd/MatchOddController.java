package com.giorgospl.MatchOdsManager.controller.matchodd;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.model.Result;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.*;
import com.giorgospl.MatchOdsManager.service.matchodd.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/v1")
@Tag(name = "Odds", description = "All about odds")
public class MatchOddController {

    @Autowired
    private GetOddsService getOddsService;

    @Autowired
    private GetMatchOddsService getMatchOddsService;

    @Autowired
    private CreateMatchOddsService createMatchOddsService;

    @Autowired
    private DeleteMatchOddsService deleteMatchOddsService;

    @Autowired
    private EditMatchOddService editMatchOddService;

    @RequestMapping(method = RequestMethod.GET, value = "/odds")
    @Operation(summary = "Gets all odds", description ="Gets all odds")
    public GetOddsResponse getOdds(HttpServletRequest httpServletRequest) throws CustomException {
        String requestId = Optional.ofNullable(httpServletRequest.getHeader("requestId"))
                .orElse(UUID.randomUUID().toString());

        return getOddsService.getOdds(requestId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/matches/{matchId}/odds")
    @Operation(summary = "Gets all match odds", description ="Gets all odds by requested matchId")
    public GetMatchOddsResponse getMatchOdds(@PathVariable String matchId, HttpServletRequest httpServletRequest) throws CustomException {
        String requestId = Optional.ofNullable(httpServletRequest.getHeader("requestId"))
                .orElse(UUID.randomUUID().toString());

        return getMatchOddsService.getMatchOdds(matchId, requestId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/matches/odds")
    @Operation(summary = "Creates new match odds", description ="Creates new match odds with given properties")
    public CreateMatchOddsResponse createMatchOdds(@Valid @RequestBody CreateMatchOddsRequest request, HttpServletRequest httpServletRequest) throws CustomException {
        String requestId = Optional.ofNullable(httpServletRequest.getHeader("requestId"))
                .orElse(UUID.randomUUID().toString());

        return createMatchOddsService.createMatchOdds(request, requestId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/matches/odds")
    @Operation(summary = "Deletes match odds", description ="Deletes match odds by requested oddIds")
    public Result deleteMatchOdds(@Valid @RequestBody DeleteMatchOddRequest request, HttpServletRequest httpServletRequest) throws CustomException {
        String requestId = Optional.ofNullable(httpServletRequest.getHeader("requestId"))
                .orElse(UUID.randomUUID().toString());

        return deleteMatchOddsService.deleteMatchOdds(request, requestId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/matches/odds")
    @Operation(summary = "Edits a match odd", description ="Edits match odd by requested oddIds")
    public Result editMatchOdd(@Valid @RequestBody EditMatchOddRequest request, HttpServletRequest httpServletRequest) throws CustomException {
        String requestId = Optional.ofNullable(httpServletRequest.getHeader("requestId"))
                .orElse(UUID.randomUUID().toString());

        return editMatchOddService.editMatchOdd(request, requestId);
    }
}
