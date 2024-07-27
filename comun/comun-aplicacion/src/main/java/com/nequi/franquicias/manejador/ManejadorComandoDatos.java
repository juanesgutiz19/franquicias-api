package com.nequi.franquicias.manejador;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComandoDatos<C, R, D> {

	@Transactional
	R ejecutar(C comando, D datos);
}