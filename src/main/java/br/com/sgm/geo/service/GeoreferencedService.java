package br.com.sgm.geo.service;

import br.com.sgm.geo.model.InfoResponse;
import br.com.sgm.geo.model.MetadataResponse;

public interface GeoreferencedService {
    InfoResponse findInfo(long idLocation);
    MetadataResponse findMetadata(Long idLocation);
}
