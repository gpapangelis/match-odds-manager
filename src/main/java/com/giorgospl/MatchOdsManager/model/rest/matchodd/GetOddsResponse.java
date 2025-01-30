package com.giorgospl.MatchOdsManager.model.rest.matchodd;

import com.giorgospl.MatchOdsManager.model.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOddsResponse extends Result {
    private List<GetOddsResponseItem> odds;
}
