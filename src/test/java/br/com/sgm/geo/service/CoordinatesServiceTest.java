package br.com.sgm.geo.service;

import br.com.sgm.geo.ibge.client.IBGEClient;
import br.com.sgm.geo.ibge.response.MeshesModel;
import br.com.sgm.geo.ibge.response.Transform;
import br.com.sgm.geo.service.impl.CoordinatesServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
public class CoordinatesServiceTest {

    @InjectMocks
    private CoordinatesServiceImpl coordinatesServiceImpl;

    @Mock
    private IBGEClient ibgeClient;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void searchCoordinates() {
        when(ibgeClient.municipalMeshesSearch("123")).thenReturn(meshes());

        coordinatesServiceImpl.searchCoordinates(123L);

        verify(ibgeClient).municipalMeshesSearch("123");
    }

    private MeshesModel meshes() {
        return MeshesModel.builder()
                .transform(transform())
                .build();
    }

    private Transform transform() {
        return Transform.builder()
                .scale(Arrays.asList("123"))
                .translate(Arrays.asList("123"))
                .build();
    }
}
