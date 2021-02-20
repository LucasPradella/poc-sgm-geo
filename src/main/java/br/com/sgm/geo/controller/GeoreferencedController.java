package br.com.sgm.geo.controller;

import br.com.sgm.geo.ibge.client.IBGEClient;
import br.com.sgm.geo.ibge.response.PopulationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class GeoreferencedController {

    @Autowired
    private IBGEClient ibgeClient;

    @RequestMapping(value = "/city-data", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> cityData() throws Exception {

        PopulationModel populationModel = ibgeClient.populationSearch("35");
        String populationModel1 = ibgeClient.municipalMeshesSearch("3538709");


        return ResponseEntity.ok(populationModel1);
    }
}
