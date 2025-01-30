package com.giorgospl.MatchOdsManager.service.match;

import com.giorgospl.MatchOdsManager.config.CustomException;
import com.giorgospl.MatchOdsManager.mapper.match.MatchMapper;
import com.giorgospl.MatchOdsManager.mapper.matchodd.MatchOddMapper;
import com.giorgospl.MatchOdsManager.model.enums.ErrorCode;
import com.giorgospl.MatchOdsManager.model.rest.match.GetMatchByIdResponse;
import com.giorgospl.MatchOdsManager.model.rest.match.GetMatchByIdResponseItem;
import com.giorgospl.MatchOdsManager.persistance.entity.MatchEntity;
import com.giorgospl.MatchOdsManager.persistance.repository.MatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class GetMatchByIdServiceImpl implements GetMatchByIdService{

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchMapper matchMapper;

    @Autowired
    private MatchOddMapper matchOddMapper;

    @Override
    public GetMatchByIdResponse getMatchById(String matchId, String requestId) throws CustomException {
        String methodName = "GetMatchesService.getMatches";
        log.info("[{}] {} service requested,", requestId, methodName);
        GetMatchByIdResponse response = new GetMatchByIdResponse();

        try{
            Optional<MatchEntity> matchEntityOpt = matchRepository.findByMatchId(matchId);

            if (matchEntityOpt.isEmpty()){
                log.error("[{}] {} No match found for the requested matchId", requestId, methodName);
                throw new CustomException(requestId, ErrorCode.CODE_4.getCode(), ErrorCode.CODE_4.getDescription());
            }

            MatchEntity matchEntity = matchEntityOpt.get();
            List<GetMatchByIdResponseItem> oddsList = matchEntity.getOdds().stream()
                            .map(odd -> matchOddMapper.oddEntityToGetMatchByIdResponseItem(odd))
                                    .toList();

            response = matchMapper.matchEntityToGetMatchByIdResponse(matchEntityOpt.get(), oddsList);

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
