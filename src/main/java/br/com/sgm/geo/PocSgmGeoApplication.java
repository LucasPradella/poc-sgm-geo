package br.com.sgm.geo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages="br.com.sgm.geo.ibge.client")
public class PocSgmGeoApplication {
	public static void main(String[] args) {
		SpringApplication.run(PocSgmGeoApplication.class, args);
	}
}

