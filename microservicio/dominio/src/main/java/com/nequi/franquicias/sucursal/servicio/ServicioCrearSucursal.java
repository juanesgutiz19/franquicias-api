package com.nequi.franquicias.sucursal.servicio;

import com.nequi.franquicias.dominio.excepcion.ExcepcionDuplicidad;
import com.nequi.franquicias.dominio.excepcion.ExcepcionSinDatos;
import com.nequi.franquicias.franquicia.modelo.entidad.Franquicia;
import com.nequi.franquicias.sucursal.modelo.entidad.Sucursal;
import com.nequi.franquicias.sucursal.puerto.repositorio.RepositorioSucursal;

import java.util.Optional;

public class ServicioCrearSucursal {

    private static final String NO_EXISTE_UNA_FRANQUICIA_CON_EL_ID_INGRESADO = "No existe una franquicia con el id ingresado";
    private static final String YA_EXISTE_UNA_SUCURSAL_CON_EL_NOMBRE_INGRESADO = "Ya existe una sucursal con el nombre %s";

    private final RepositorioSucursal repositorioSucursal;

    public ServicioCrearSucursal(RepositorioSucursal repositorioSucursal) {
        this.repositorioSucursal = repositorioSucursal;
    }

    public Long ejecutar(Sucursal sucursal) {
        Optional<Franquicia> franquicia = Optional.ofNullable(sucursal.getFranquicia());
        Optional<Sucursal> sucursalObtenida = Optional.ofNullable(repositorioSucursal.obtenerPorNombre(sucursal.getNombre()));

        if (franquicia.isEmpty()) {
            throw new ExcepcionSinDatos(NO_EXISTE_UNA_FRANQUICIA_CON_EL_ID_INGRESADO);
        }

        if (sucursalObtenida.isPresent()) {
            throw new ExcepcionDuplicidad(String.format(YA_EXISTE_UNA_SUCURSAL_CON_EL_NOMBRE_INGRESADO, sucursal.getNombre()));
        }

        return repositorioSucursal.guardar(Sucursal.crear(sucursal));
    }
}
