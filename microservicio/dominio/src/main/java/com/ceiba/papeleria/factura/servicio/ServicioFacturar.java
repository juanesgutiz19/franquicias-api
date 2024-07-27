package com.nequi.franquicias.factura.servicio;

import com.nequi.franquicias.factura.modelo.entidad.Factura;
import com.nequi.franquicias.factura.modelo.entidad.SolicitudFacturar;
import com.nequi.franquicias.factura.puerto.repositorio.RepositorioFactura;

public class ServicioFacturar {
    private final RepositorioFactura repositorioFactura;

    public ServicioFacturar(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public Long ejecutar(SolicitudFacturar solicitudFacturar) {
        Factura factura = Factura.crear(solicitudFacturar);
        return repositorioFactura.guardar(factura);
    }
}
