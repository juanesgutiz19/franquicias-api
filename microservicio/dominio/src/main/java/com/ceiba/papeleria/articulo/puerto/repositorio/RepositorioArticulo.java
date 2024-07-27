package com.nequi.franquicias.articulo.puerto.repositorio;

import com.nequi.franquicias.articulo.modelo.entidad.Articulo;

public interface RepositorioArticulo {

    Articulo obtener(String codigo);
}
