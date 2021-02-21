package br.com.sgm.geo.service.impl;

import br.com.sgm.geo.ibge.client.IBGEClient;
import br.com.sgm.geo.ibge.response.MeshesModel;
import br.com.sgm.geo.ibge.response.Transform;
import br.com.sgm.geo.model.CoordinatesResponse;
import br.com.sgm.geo.service.CoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinatesServiceImpl implements CoordinatesService {

    @Autowired
    private IBGEClient ibgeClient;

    @Override
    public CoordinatesResponse searchCoordinates(long local) {
        MeshesModel meshesModel = ibgeClient.municipalMeshesSearch(String.valueOf(local));

        return convert(meshesModel.getTransform());
    }

    private CoordinatesResponse convert(Transform transform) {
        CoordinatesResponse response = new CoordinatesResponse();
        response.setScale(transform.getScale());
        response.setTranslate(transform.getTranslate());
        return response;
    }

}
