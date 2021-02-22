package br.com.sgm.geo.ibge.client;

import br.com.sgm.geo.ibge.response.AggregatesModel;
import br.com.sgm.geo.ibge.response.MeshesModel;
import br.com.sgm.geo.ibge.response.NewsModel;
import br.com.sgm.geo.ibge.response.PopulationModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url="https://servicodados.ibge.gov.br/api/", name = "servicoDadosIBGE")
public interface IBGEClient {

    @GetMapping("v1/projecoes/populacao/{locality}")
    PopulationModel populationSearch(@PathVariable("locality") String locality);

    @GetMapping("v3/malhas/municipios/{code}?formato=application/json")
    MeshesModel municipalMeshesSearch(@PathVariable("code") String code);

    @GetMapping("v3/noticias/?qtd=1")
    NewsModel newsSearch();

    @GetMapping("v3/agregados/1278/variaveis?localidades=N9[{locality}]")
    List<AggregatesModel> agriculturalAggregates(@PathVariable("locality") Long locality);

}
