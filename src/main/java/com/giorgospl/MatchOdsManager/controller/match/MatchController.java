package com.giorgospl.MatchOdsManager.controller.match;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.model.Result;
import com.giorgospl.MatchOdsManager.model.rest.match.*;
import com.giorgospl.MatchOdsManager.service.match.*;
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
@Tag(name = "Matches", description = "All about matches")
public class MatchController {

    @Autowired
    private GetMatchesService getMatchesService;

    @Autowired
    private GetMatchByIdService getMatchByIdService;

    @Autowired
    private CreateMatchService createMatchService;

    @Autowired
    private DeleteMatchByIdService deleteMatchByIdService;

    @Autowired
    private EditMatchService editMatchService;

    @RequestMapping(method = RequestMethod.GET, value = "/matches")
    @Operation(summary = "Gets all matches", description ="Gets all matches")
    public GetMatchesResponse getMatches(HttpServletRequest httpServletRequest) throws CustomException {
        String requestId = Optional.ofNullable(httpServletRequest.getHeader("requestId"))
                .orElse(UUID.randomUUID().toString());

        return getMatchesService.getMatches(requestId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/matches/{matchId}")
    @Operation(summary = "Gets a specific match", description ="Gets a specific match by requested matchId")
    public GetMatchByIdResponse getMatchById(@PathVariable String matchId, HttpServletRequest httpServletRequest) throws CustomException {
        String requestId = Optional.ofNullable(httpServletRequest.getHeader("requestId"))
                .orElse(UUID.randomUUID().toString());

        return getMatchByIdService.getMatchById(matchId, requestId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/matches")
    @Operation(summary = "Creates a new match", description ="Creates a new match with the given properties")
    public CreateMatchResponse createMatch(@Valid @RequestBody CreateMatchRequest request, HttpServletRequest httpServletRequest) throws CustomException {
        String requestId = Optional.ofNullable(httpServletRequest.getHeader("requestId"))
                .orElse(UUID.randomUUID().toString());

        return createMatchService.createMatch(request, requestId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/matches/{matchId}")
    @Operation(summary = "Deletes a specific match", description ="Deletes a specific match by requested matchId")
    public Result deleteMatch(@PathVariable String matchId, HttpServletRequest httpServletRequest) throws CustomException {
        String requestId = Optional.ofNullable(httpServletRequest.getHeader("requestId"))
                .orElse(UUID.randomUUID().toString());

        return deleteMatchByIdService.deleteMatchById(matchId, requestId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/matches")
    @Operation(summary = "Edits a specific match", description ="Edits a specific match by requested matchId")
    public Result editMatch(@Valid @RequestBody EditMatchRequest request, HttpServletRequest httpServletRequest) throws CustomException {
        String requestId = Optional.ofNullable(httpServletRequest.getHeader("requestId"))
                .orElse(UUID.randomUUID().toString());

        return editMatchService.editMatchService(request, requestId);
    }


}
