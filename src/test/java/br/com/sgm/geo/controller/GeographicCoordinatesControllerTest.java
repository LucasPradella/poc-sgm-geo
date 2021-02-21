package br.com.sgm.geo.controller;

import br.com.sgm.geo.service.CoordinatesService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
class GeographicCoordinatesControllerTest {

    @InjectMocks
    private GeographicCoordinatesController geographicCoordinatesController;

    @Mock
    private CoordinatesService coordinatesService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    void coordinates() {

        geographicCoordinatesController.coordinates(3538709L);

        verify(coordinatesService).searchCoordinates(3538709L);

    }
}