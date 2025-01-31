package com.giorgospl.MatchOdsManager.service.match;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.model.Result;
import com.giorgospl.MatchOdsManager.model.enums.ErrorCode;
import com.giorgospl.MatchOdsManager.persistance.entity.MatchEntity;
import com.giorgospl.MatchOdsManager.persistance.repository.MatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class DeleteMatchByIdServiceImpl implements DeleteMatchByIdService{

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public Result deleteMatchById(String matchId, String requestId) throws CustomException {
        String methodName = "DeleteMatchByIdService.deleteMatchById";
        log.info("[{}] {} service requested,", requestId, methodName);
        Result response = new Result();

        try{
            Optional<MatchEntity> matchEntityOpt = matchRepository.findByMatchId(matchId);

            if (matchEntityOpt.isEmpty()){
                log.error("[{}] {} No match found for the requested matchId", requestId, methodName);
                throw new CustomException(requestId, ErrorCode.CODE_4.getCode(), ErrorCode.CODE_4.getDescription());
            }

            matchRepository.delete(matchEntityOpt.get());

        }catch (CustomException e){
            log.error("[{}] {} Custom exception: {}", requestId, methodName, e.toString());
            e.printStackTrace();
            response.setErrorLevel(1);
            response.setErrorCode(e.getErrorCode());
            response.setErrorMessage(e.getErrorMessage());
            response.setSuccess(false);
            return response;
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
