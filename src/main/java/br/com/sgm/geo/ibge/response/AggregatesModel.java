package br.com.sgm.geo.ibge.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AggregatesModel {

        private String variavel;
        private String unidade;
        private List<Resultados>  resultados;
}
