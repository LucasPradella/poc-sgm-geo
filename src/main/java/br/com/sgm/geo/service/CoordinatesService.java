package br.com.sgm.geo.service;

import br.com.sgm.geo.model.CoordinatesResponse;

public interface CoordinatesService {

    CoordinatesResponse searchCoordinates(long local);

}
