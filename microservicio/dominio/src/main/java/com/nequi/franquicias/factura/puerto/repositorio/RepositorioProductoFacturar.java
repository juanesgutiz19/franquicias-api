package com.nequi.franquicias.factura.puerto.repositorio;

import com.nequi.franquicias.factura.modelo.entidad.Factura;
import com.nequi.franquicias.factura.modelo.entidad.ProductoFacturar;

import java.util.List;

public interface RepositorioProductoFacturar {

    void guardarPorFactura(Factura factura, Long idFactura);

    List<ProductoFacturar> obtenerPorFactura(Long idFactura);
}
