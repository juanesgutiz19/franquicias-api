package com.nequi.franquicias.manejador;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorDatos<D> {

    @Transactional
    void ejecutar(D primerDato, D segundoDato);
}
