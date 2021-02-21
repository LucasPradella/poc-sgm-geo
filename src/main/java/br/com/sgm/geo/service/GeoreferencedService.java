package br.com.sgm.geo.service;

import br.com.sgm.geo.model.InfoResponse;

public interface GeoreferencedService {

    InfoResponse findInfo(long idLocation);

}
