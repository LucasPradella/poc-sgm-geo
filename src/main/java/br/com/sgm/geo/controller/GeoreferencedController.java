package br.com.sgm.geo.controller;

import br.com.sgm.geo.api.CityDataApi;
import br.com.sgm.geo.ibge.client.IBGEClient;
import br.com.sgm.geo.ibge.response.PopulationModel;
import br.com.sgm.geo.model.InfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class GeoreferencedController implements CityDataApi {

    @Autowired
    private IBGEClient ibgeClient;

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<InfoResponse> cityData(Long idLocation) {
        PopulationModel populationModel = ibgeClient.populationSearch("35");
        String populationModel1 = ibgeClient.municipalMeshesSearch("3538709");


        return ResponseEntity.ok(new InfoResponse());

    }
}
