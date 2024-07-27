package com.nequi.franquicias.venta.servicio;

import com.nequi.franquicias.venta.modelo.entidad.SolicitudRegistrar;
import com.nequi.franquicias.venta.modelo.entidad.Venta;
import com.nequi.franquicias.venta.puerto.repositorio.RepositorioVenta;

public class ServicioRegistrar {

    private final RepositorioVenta repositorioVenta;

    public ServicioRegistrar(RepositorioVenta repositorioVenta) {
        this.repositorioVenta = repositorioVenta;
    }

    public Long ejecutar(SolicitudRegistrar solicitudRegistrar){
        Venta venta = Venta.crear(solicitudRegistrar);
        return repositorioVenta.guardar(venta);
        // Lógica para restar en los inventarios

    }
}
