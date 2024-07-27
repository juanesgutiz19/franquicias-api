package com.nequi.franquicias.producto.puerto;

import com.nequi.franquicias.producto.entidad.Producto;

public interface RepositorioProducto {

    Producto obtener(Long id);
}
