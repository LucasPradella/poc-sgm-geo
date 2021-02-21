package br.com.sgm.geo.controller;

import br.com.sgm.geo.api.CityDataApi;
import br.com.sgm.geo.model.InfoResponse;
import br.com.sgm.geo.model.MetadataResponse;
import br.com.sgm.geo.service.GeoreferencedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class GeoreferencedController implements CityDataApi {

    @Autowired
    private GeoreferencedService georeferencedService;


    @Override // TODO: alterar role para permitir apenas usuarios não admin tenha acesso
    public ResponseEntity<MetadataResponse> metadata(Long idLocation) {
        return null;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')") // TODO: alterar role, para permitir acesso a todos usuarios
    public ResponseEntity<InfoResponse> searchData(Long idLocation) {
        InfoResponse info = georeferencedService.findInfo(idLocation);

        return ResponseEntity.ok(info);
    }
}
