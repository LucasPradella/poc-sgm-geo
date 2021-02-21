package br.com.sgm.geo.service.impl;

import br.com.sgm.geo.ibge.client.IBGEClient;
import br.com.sgm.geo.ibge.response.Items;
import br.com.sgm.geo.ibge.response.NewsModel;
import br.com.sgm.geo.model.InfoResponse;
import br.com.sgm.geo.service.GeoreferencedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeoreferencedServiceImpl implements GeoreferencedService {

    @Autowired
    private IBGEClient ibgeClient;


    @Override
    public InfoResponse findInfo(long idLocation) {
        NewsModel newsModel = ibgeClient.newsSearch();

        return convertResponse(newsModel.getItems().get(0));
    }







    private InfoResponse convertResponse(Items news) {
        InfoResponse infoResponse = new InfoResponse();
        infoResponse.setLink(news.getLink());
        infoResponse.setTypeSubject(news.getTipo());
        infoResponse.setTitle(news.getTitulo());
        infoResponse.setIntroduction(news.getIntroducao());
        infoResponse.setSubject(news.getProdutos());
        infoResponse.setEditorials(news.getEditorias());
        return infoResponse;
    }

}
