package com.giorgospl.MatchOdsManager.service.matchodd;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.mapper.matchodd.MatchOddMapper;
import com.giorgospl.MatchOdsManager.model.enums.ErrorCode;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.GetOddsResponse;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.GetOddsResponseItem;
import com.giorgospl.MatchOdsManager.persistance.entity.MatchOddEntity;
import com.giorgospl.MatchOdsManager.persistance.repository.MatchOddRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GetOddsServiceImpl implements GetOddsService{

    @Autowired
    private MatchOddRepository matchOddRepository;

    @Autowired
    private MatchOddMapper matchOddMapper;

    @Override
    public GetOddsResponse getOdds(String requestId) throws CustomException{
        String methodName = "GetMatchesService.getMatches";
        log.info("[{}] {} service requested,", requestId, methodName);
        GetOddsResponse response = new GetOddsResponse();

        try{
            List<MatchOddEntity> matchOddEntityList = matchOddRepository.findAll();

            if (matchOddEntityList.isEmpty()){
                log.error("[{}] {} No odds found", requestId, methodName);
                throw new CustomException(requestId, ErrorCode.CODE_5.getCode(), ErrorCode.CODE_5.getDescription());
            }

            List<GetOddsResponseItem> oddsResponseItemList = matchOddEntityList.stream()
                    .map(odd -> matchOddMapper.oddEntityToGetOddsResponseItem(odd))
                            .toList();

            response.setOdds(oddsResponseItemList);

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
