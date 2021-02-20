package br.com.sgm.geo.ibge.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PopulationModel {

    private String localidade;
    private String horario;
    private Projecao projecao;

    @Data
    static class Projecao {
        private String populacao;
        private PeriodoMedio periodoMedio;
    }

    @Data
    static class PeriodoMedio {
        private int incrementoPopulacional;
    }

}


