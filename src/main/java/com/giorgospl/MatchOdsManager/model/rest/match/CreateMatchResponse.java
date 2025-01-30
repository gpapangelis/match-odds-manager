package com.giorgospl.MatchOdsManager.model.rest.match;

import com.giorgospl.MatchOdsManager.model.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMatchResponse extends Result {
    private String matchId;
}
