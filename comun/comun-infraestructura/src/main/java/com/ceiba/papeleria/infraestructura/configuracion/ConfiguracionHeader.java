package com.nequi.franquicias.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.nequi.franquicias.infraestructura.filtro.FiltroHeaderSeguridad;

@Configuration
public class ConfiguracionHeader {
	
	@Bean
	public FiltroHeaderSeguridad filtroHeader() {
		return new FiltroHeaderSeguridad();
	}

}