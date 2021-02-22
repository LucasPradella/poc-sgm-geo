package br.com.sgm.geo.service.impl;

import br.com.sgm.geo.ibge.client.IBGEClient;
import br.com.sgm.geo.ibge.response.AggregatesModel;
import br.com.sgm.geo.ibge.response.Items;
import br.com.sgm.geo.ibge.response.NewsModel;
import br.com.sgm.geo.model.DataResponse;
import br.com.sgm.geo.model.InfoResponse;
import br.com.sgm.geo.model.MetadataResponse;
import br.com.sgm.geo.service.GeoreferencedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeoreferencedServiceImpl implements GeoreferencedService {

    @Autowired
    private IBGEClient ibgeClient;


    @Override
    public InfoResponse findInfo(long idLocation) {
        NewsModel newsModel = ibgeClient.newsSearch();

        return convertResponse(newsModel.getItems().get(0));
    }

    @Override
    public MetadataResponse findMetadata(Long idLocation) {
        List<AggregatesModel> aggregatesModels = ibgeClient.agriculturalAggregates(idLocation);

        if (aggregatesModels == null || aggregatesModels.isEmpty()){
            return null;
        }

        return convertResponse(aggregatesModels);
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

    private MetadataResponse convertResponse(List<AggregatesModel> aggregatesModel) {
        MetadataResponse metadataResponse = new MetadataResponse();
        metadataResponse.setData(data(aggregatesModel));

        metadataResponse.setNameCity("Bom Destino");

        return metadataResponse;
    }

    private List<DataResponse> data(List<AggregatesModel> aggregatesModel) {
        List<DataResponse> dataResponse = new ArrayList<>();

        aggregatesModel.forEach(a -> {
            DataResponse data = new DataResponse();
            data.setDescription(a.getVariavel());
            data.setUnit(a.getUnidade());
            data.setCount(a.getResultados().get(0).getSeries().get(0).getSerie().getValor());
            dataResponse.add(data);
        });

        return dataResponse;
    }
}
