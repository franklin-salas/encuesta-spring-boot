package com.lanister.encuesta.utils.transformer;

import com.lanister.encuesta.dto.response.PollResultResponse;
import com.lanister.encuesta.dto.response.ResultDetailResponse;
import com.lanister.encuesta.interfaces.PollResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PollResultTransformer implements Transformer<List<PollResult>, List<PollResultResponse>>{
    @Override
    public List<PollResultResponse> transformData(List<PollResult> data) {
        Map<String, PollResultResponse> transformedData = new HashMap<>();

        for (PollResult result : data){
            PollResultResponse pollResultResponse;
            String key = Long.toString(result.getQuestionId());
            if (!transformedData.containsKey(key)){
                List<ResultDetailResponse> details = new ArrayList<>();
                details.add(new ResultDetailResponse(result.getAnswer(), result.getResult()));
                pollResultResponse = new PollResultResponse(result.getQuestion(),details);
                transformedData.put(key,pollResultResponse);
            }else {
                pollResultResponse = transformedData.get(key);
                pollResultResponse.getDetails().add(new ResultDetailResponse(result.getAnswer(),result.getResult()));
            }
        }

        List<PollResultResponse> resultResponses = new ArrayList<>(transformedData.values());
        return resultResponses;
    }
}
