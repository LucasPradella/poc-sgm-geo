package br.com.sgm.geo.ibge.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class NewsModel {

    private int count;
    private List<Items> items;
}
