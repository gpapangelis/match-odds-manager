package com.giorgospl.MatchOdsManager.model.rest.matchodd;

import com.giorgospl.MatchOdsManager.model.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMatchOddsResponse extends Result {
    private List<CreateMatchOddsResponseItem> createdOdds;
}
