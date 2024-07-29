package com.nequi.franquicias.sucursal.servicio;

import com.nequi.franquicias.dominio.excepcion.ExcepcionSinDatos;
import com.nequi.franquicias.sucursal.modelo.entidad.Sucursal;
import com.nequi.franquicias.sucursal.puerto.repositorio.RepositorioSucursal;

import java.util.Optional;

public class ServicioActualizarNombreSucursal {

    private static final String NO_EXISTE_UNA_SUCURSAL_CON_EL_ID = "No existe una sucursal con el id %d";

    private final RepositorioSucursal repositorioSucursal;

    public ServicioActualizarNombreSucursal(RepositorioSucursal repositorioSucursal) {
        this.repositorioSucursal = repositorioSucursal;
    }

    public void ejecutar(Sucursal sucursal) {
        Optional<Sucursal> sucursalRecuperada = Optional.ofNullable(repositorioSucursal.obtenerPorId(sucursal.getId()));

        if (sucursalRecuperada.isEmpty()) {
            throw new ExcepcionSinDatos(String.format(NO_EXISTE_UNA_SUCURSAL_CON_EL_ID, sucursal.getId()));
        }

        repositorioSucursal.actualizarNombre(sucursal);
    }
}
