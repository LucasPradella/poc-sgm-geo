package br.com.sgm.geo.controller;

import br.com.sgm.geo.api.GeographicCoordinatesApi;
import br.com.sgm.geo.model.CoordinatesResponse;
import br.com.sgm.geo.service.CoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class GeographicCoordinatesController implements GeographicCoordinatesApi {

    @Autowired
    private CoordinatesService coordinatesService;

    @Override // TODO: alterar role para permitir apenas aplicações tenha acesso
    public ResponseEntity<CoordinatesResponse> coordinates(Long idLocation) {
        CoordinatesResponse coordinatesResponse = coordinatesService.searchCoordinates(idLocation);
        return ResponseEntity.ok(coordinatesResponse);
    }


}
