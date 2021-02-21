package br.com.sgm.geo.service;

import br.com.sgm.geo.ibge.client.IBGEClient;
import br.com.sgm.geo.ibge.response.Items;
import br.com.sgm.geo.ibge.response.NewsModel;
import br.com.sgm.geo.model.InfoResponse;
import br.com.sgm.geo.service.impl.GeoreferencedServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


@SpringBootTest
public class GeoreferencedServiceTest {

    @InjectMocks
    private GeoreferencedServiceImpl georeferencedService;

    @Mock
    private IBGEClient ibgeClient;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    void mustCallClassWithClientAndTheVariableLinkMustBeFilled() {
        when(ibgeClient.newsSearch()).thenReturn(newsModel());

        InfoResponse info = georeferencedService.findInfo(3538709L);

        verify(ibgeClient).newsSearch();
        assertEquals("link", info.getLink());

    }

    private NewsModel newsModel() {
        return NewsModel.builder()
                .items(itens())
                .build();
    }

    private List<Items> itens() {
        return Arrays.asList(Items.builder()
                .link("link")
                .build());
    }

}
