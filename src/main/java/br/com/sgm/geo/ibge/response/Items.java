package br.com.sgm.geo.ibge.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Items {
    private int id;
    private String tipo;
    private String titulo;
    private String introducao;
    private String data_publicacao;
    private int produto_id;
    private String produtos;
    private String editorias;
    private String link;
}