package com.nequi.franquicias.inventario.puerto.repositorio;

import com.nequi.franquicias.inventario.modelo.entidad.Inventario;

public interface RepositorioInventario {

    Inventario obtenerPorArticulo(String idArticulo);

    void actualizarCantidadDisponibleArticulo(Inventario inventario);
}
