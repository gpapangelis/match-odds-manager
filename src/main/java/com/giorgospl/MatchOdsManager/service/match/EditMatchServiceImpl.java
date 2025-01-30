package com.giorgospl.MatchOdsManager.service.match;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.model.Result;
import com.giorgospl.MatchOdsManager.model.enums.ErrorCode;
import com.giorgospl.MatchOdsManager.model.rest.match.EditMatchRequest;
import com.giorgospl.MatchOdsManager.persistance.entity.MatchEntity;
import com.giorgospl.MatchOdsManager.persistance.repository.MatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class EditMatchServiceImpl implements EditMatchService{

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public Result editMatchService(EditMatchRequest request, String requestId) throws CustomException {
        String methodName = "EditMatchService.editMatchService";
        log.info("[{}] {} service requested,", requestId, methodName);
        Result response = new Result();

        try{
            Optional<MatchEntity> matchEntityOpt = matchRepository.findByMatchId(request.getMatchId());

            if (matchEntityOpt.isEmpty()){
                log.error("[{}] {} No match found for the requested matchId", requestId, methodName);
                throw new CustomException(requestId, ErrorCode.CODE_4.getCode(), ErrorCode.CODE_4.getDescription());
            }

            MatchEntity matchEntity = matchEntityOpt.get();
            matchEntity.setDescription(request.getDescription() != null ? request.getDescription() : matchEntity.getDescription());
            matchEntity.setDate(request.getMatchDate() != null ? request.getMatchDate() : matchEntity.getDate());
            matchEntity.setTime(request.getMatchTime() != null ? request.getMatchTime() : matchEntity.getTime());
            matchEntity.setFirstTeam(request.getFirstTeam() != null ? request.getFirstTeam() : matchEntity.getFirstTeam());
            matchEntity.setSecondTeam(request.getSecondTeam() != null ? request.getSecondTeam() : matchEntity.getSecondTeam());
            matchEntity.setSport(request.getSport() != null ? request.getSport().getCode() : matchEntity.getSport());

            matchRepository.save(matchEntity);

        }catch (CustomException e){
            log.error("[{}] {} Custom exception: {}", requestId, methodName, e.toString());
            e.printStackTrace();
            response.setErrorLevel(1);
            response.setErrorCode(e.getErrorCode());
            response.setErrorMessage(e.getErrorMessage());
            response.setSuccess(false);
            throw e;
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
