package com.giorgospl.MatchOdsManager.service.matchodd;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.mapper.matchodd.MatchOddMapper;
import com.giorgospl.MatchOdsManager.model.enums.ErrorCode;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.CreateMatchOddsRequest;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.CreateMatchOddsResponse;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.GetMatchOddsResponse;
import com.giorgospl.MatchOdsManager.model.rest.matchodd.GetMatchOddsResponseItem;
import com.giorgospl.MatchOdsManager.persistance.entity.MatchEntity;
import com.giorgospl.MatchOdsManager.persistance.entity.MatchOddEntity;
import com.giorgospl.MatchOdsManager.persistance.repository.MatchOddRepository;
import com.giorgospl.MatchOdsManager.persistance.repository.MatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CreateMatchOddsServiceImpl implements CreateMatchOddsService{

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchOddRepository matchOddRepository;

    @Autowired
    private MatchOddMapper matchOddMapper;

    @Override
    public CreateMatchOddsResponse createMatchOdds(CreateMatchOddsRequest request, String requestId) throws CustomException {
        String methodName = "CreateMatchOddsService.createMatchOdds";
        log.info("[{}] {} service requested,", requestId, methodName);
        CreateMatchOddsResponse response = new CreateMatchOddsResponse();

        try{
            Optional<MatchEntity> matchEntityList = matchRepository.findByMatchId(request.getMatchId());

            if (matchEntityList.isEmpty()){
                log.error("[{}] {} No match found for the requested matchId", requestId, methodName);
                throw new CustomException(requestId, ErrorCode.CODE_4.getCode(), ErrorCode.CODE_4.getDescription());
            }

            MatchEntity matchEntity = matchEntityList.get();

            List<MatchOddEntity> matchOddEntityList = request.getOdds().stream()
                    .map(odd -> matchOddMapper.createMatchOddsRequestToMatchOddEntity(odd, matchEntity))
                    .toList();

            matchOddRepository.saveAll(matchOddEntityList);

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
