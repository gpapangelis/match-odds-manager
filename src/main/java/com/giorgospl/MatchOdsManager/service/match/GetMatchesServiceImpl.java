package com.giorgospl.MatchOdsManager.service.match;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.mapper.match.MatchMapper;
import com.giorgospl.MatchOdsManager.model.enums.ErrorCode;
import com.giorgospl.MatchOdsManager.model.rest.match.GetMatchesResponse;
import com.giorgospl.MatchOdsManager.model.rest.match.GetMatchesResponseItem;
import com.giorgospl.MatchOdsManager.persistance.entity.MatchEntity;
import com.giorgospl.MatchOdsManager.persistance.repository.MatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GetMatchesServiceImpl implements GetMatchesService{

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchMapper matchMapper;

    @Override
    public GetMatchesResponse getMatches(String requestId) throws CustomException {
        String methodName = "GetMatchesService.getMatches";
        log.info("[{}] {} service requested,", requestId, methodName);
        GetMatchesResponse response = new GetMatchesResponse();

        try{
            List<MatchEntity> matchEntityList = matchRepository.findAll();

            if (matchEntityList.isEmpty()){
                log.error("[{}] {} No matches found", requestId, methodName);
                throw new CustomException(requestId, ErrorCode.CODE_3.getCode(), ErrorCode.CODE_3.getDescription());
            }

            List<GetMatchesResponseItem> matches = matchEntityList.stream()
                    .map(match -> matchMapper.matchEntityToGetMatchesResponseItem(match))
                    .toList();
            response.setMatches(matches);

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
