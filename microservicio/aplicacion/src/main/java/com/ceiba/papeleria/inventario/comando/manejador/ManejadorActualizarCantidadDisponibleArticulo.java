package com.nequi.franquicias.inventario.comando.manejador;

import com.nequi.franquicias.inventario.comando.ComandoActualizarCantidadDisponible;
import com.nequi.franquicias.inventario.puerto.repositorio.RepositorioInventario;
import com.nequi.franquicias.inventario.servicio.ServicioActualizarCantidadDisponible;
import com.nequi.franquicias.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCantidadDisponibleArticulo implements ManejadorComando<ComandoActualizarCantidadDisponible> {

    private final ServicioActualizarCantidadDisponible servicioActualizarCantidadDisponible;
    private final RepositorioInventario repositorioInventario;

    public ManejadorActualizarCantidadDisponibleArticulo(ServicioActualizarCantidadDisponible servicioActualizarCantidadDisponible, RepositorioInventario repositorioInventario) {
        this.servicioActualizarCantidadDisponible = servicioActualizarCantidadDisponible;
        this.repositorioInventario = repositorioInventario;
    }

    @Override
    public void ejecutar(ComandoActualizarCantidadDisponible comandoActualizarCantidadDisponible) {
        servicioActualizarCantidadDisponible.ejecutar(repositorioInventario.obtenerPorArticulo(comandoActualizarCantidadDisponible.getIdArticulo()), comandoActualizarCantidadDisponible.getCantidad());
    }
}
