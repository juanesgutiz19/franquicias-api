package com.nequi.franquicias.inventariosucursal.comando.manejador;

import com.nequi.franquicias.inventariosucursal.servicio.ServicioEliminarProductoASucursal;
import com.nequi.franquicias.manejador.ManejadorDatos;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarProductoASucursal implements ManejadorDatos<Long> {

    private final ServicioEliminarProductoASucursal servicioEliminarProductoASucursal;

    public ManejadorEliminarProductoASucursal(ServicioEliminarProductoASucursal servicioEliminarProductoASucursal) {
        this.servicioEliminarProductoASucursal = servicioEliminarProductoASucursal;
    }

    @Override
    public void ejecutar(Long sucursalId, Long productoId) {
        servicioEliminarProductoASucursal.ejecutar(sucursalId, productoId);
    }
}
