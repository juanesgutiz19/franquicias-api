package com.nequi.franquicias.articulo.puerto.dao;

import com.nequi.franquicias.articulo.modelo.dto.ArticuloDTO;

import java.util.List;

public interface DaoArticulo {

    List<ArticuloDTO> obtenerArticulosPorNombre(String nombre);

}
