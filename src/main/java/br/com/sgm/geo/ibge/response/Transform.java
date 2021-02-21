package br.com.sgm.geo.ibge.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Transform {
    private List<String> scale;
    private List<String> translate;
}
