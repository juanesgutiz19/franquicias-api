package com.nequi.franquicias.factura.puerto.repositorio;

import com.nequi.franquicias.factura.modelo.entidad.Factura;

public interface RepositorioFactura {
    Long guardar(Factura factura);
    Factura obtener(Long id);
    void actualizarEstado(Factura factura);
}
