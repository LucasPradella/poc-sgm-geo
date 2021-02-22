package br.com.sgm.geo.controller;

import br.com.sgm.geo.model.InfoResponse;
import br.com.sgm.geo.service.GeoreferencedService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;


@SpringBootTest
public class GeoreferencedControllerTest {

    @InjectMocks
    private GeoreferencedController georeferencedController;

    @Mock
    private GeoreferencedService georeferencedService;

    @Before
    public void setUp() throws Exception {
         initMocks(this);
    }


    @Test
    void shouldCallGeoreferencedServiceAndNotReturnNull() {
        ResponseEntity<InfoResponse> InfoResponse = georeferencedController.searchData(3538709L);

        verify(georeferencedService).findInfo(3538709L);
        assertNotNull(InfoResponse);

    }

    @Test
    void metadata() {
        georeferencedController.metadata(3538709L);

        verify(georeferencedService).findMetadata(3538709L);
    }
}
