package com.giorgospl.MatchOdsManager.service.matchodd;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.model.Result;
import com.giorgospl.MatchOdsManager.model.enums.ErrorCode;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.EditMatchOddRequest;
import com.giorgospl.MatchOdsManager.persistance.entity.MatchOddEntity;
import com.giorgospl.MatchOdsManager.persistance.repository.MatchOddRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class EditMatchOddServiceImpl implements EditMatchOddService{

    @Autowired
    private MatchOddRepository matchOddRepository;

    @Override
    public Result editMatchOdd(EditMatchOddRequest request, String requestId) throws CustomException {
        String methodName = "EditMatchOddService.editMatchOdd";
        log.info("[{}] {} service requested,", requestId, methodName);
        Result response = new Result();

        try{

            Optional<MatchOddEntity> matchOddOpt = matchOddRepository.findByOddIdAndMatch_MatchId(request.getOddId(), request.getMatchId());

            if (matchOddOpt.isEmpty()){
                log.error("[{}] {} No odd found for the requested matchId and oddId", requestId, methodName);
                throw new CustomException(requestId, ErrorCode.CODE_6.getCode(), ErrorCode.CODE_6.getDescription());
            }

            MatchOddEntity matchOddEntity = matchOddOpt.get();
            matchOddEntity.setSpecifier(request.getSpecifier() != null ? request.getSpecifier() : matchOddEntity.getSpecifier());
            matchOddEntity.setOdd(request.getOdd() != null ? request.getOdd() : matchOddEntity.getOdd());

            matchOddRepository.save(matchOddEntity);

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
