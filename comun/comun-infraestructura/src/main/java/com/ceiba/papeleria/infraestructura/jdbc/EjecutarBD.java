package com.nequi.franquicias.infraestructura.jdbc;

public interface EjecutarBD<T> {
    T ejecutar();
}