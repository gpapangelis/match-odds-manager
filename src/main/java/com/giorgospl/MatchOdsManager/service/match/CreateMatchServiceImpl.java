package com.giorgospl.MatchOdsManager.service.match;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.mapper.match.MatchMapper;
import com.giorgospl.MatchOdsManager.model.enums.ErrorCode;
import com.giorgospl.MatchOdsManager.model.rest.match.CreateMatchRequest;
import com.giorgospl.MatchOdsManager.model.rest.match.CreateMatchResponse;
import com.giorgospl.MatchOdsManager.persistance.entity.MatchEntity;
import com.giorgospl.MatchOdsManager.persistance.repository.MatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CreateMatchServiceImpl implements CreateMatchService{

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchMapper matchMapper;

    @Override
    public CreateMatchResponse createMatch(CreateMatchRequest request, String requestId) throws CustomException{
        String methodName = "CreateMatchService.createMatch";
        log.info("[{}] {} service requested,", requestId, methodName);
        CreateMatchResponse response = new CreateMatchResponse();

        try{
            MatchEntity matchEntity = matchMapper.createMatchRequestToMatchEntity(request);
            matchRepository.save(matchEntity);

            response.setMatchId(matchEntity.getMatchId());

        }catch (Exception e){
            log.error("[{}] {} Exception: {}", requestId, methodName, e.toString());
            response.setErrorLevel(1);
            response.setErrorCode(ErrorCode.CODE_2.getCode());
            response.setErrorMessage(ErrorCode.CODE_2.getDescription());
            response.setSuccess(false);
            throw new CustomException(requestId, ErrorCode.CODE_2.getCode(), ErrorCode.CODE_2.getDescription());
        }
        return response;
    }
}
