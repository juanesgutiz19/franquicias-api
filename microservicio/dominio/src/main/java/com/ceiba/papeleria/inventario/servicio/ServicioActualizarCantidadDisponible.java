package com.nequi.franquicias.inventario.servicio;

import com.nequi.franquicias.dominio.ValidadorArgumento;
import com.nequi.franquicias.inventario.modelo.entidad.Inventario;
import com.nequi.franquicias.inventario.puerto.repositorio.RepositorioInventario;

public class ServicioActualizarCantidadDisponible {

    private static final String MENSAJE_REGISTRO_INVENTARIO_NO_EXISTE = "No existe registro de inventario asociado al código del artículo enviado";

    private final RepositorioInventario repositorioInventario;

    public ServicioActualizarCantidadDisponible(RepositorioInventario repositorioInventario) {
        this.repositorioInventario = repositorioInventario;
    }

    public void ejecutar(Inventario inventario, Integer cantidadAAgregar) {
        ValidadorArgumento.validarObligatorio(inventario, MENSAJE_REGISTRO_INVENTARIO_NO_EXISTE);
        inventario.actualizarCantidadDisponible(cantidadAAgregar);
        repositorioInventario.actualizarCantidadDisponibleArticulo(inventario);
    }

}