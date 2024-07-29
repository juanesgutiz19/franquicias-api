package com.nequi.franquicias.franquicia.servicio;

import com.nequi.franquicias.dominio.excepcion.ExcepcionSinDatos;
import com.nequi.franquicias.franquicia.modelo.entidad.Franquicia;
import com.nequi.franquicias.franquicia.puerto.repositorio.RepositorioFranquicia;

import java.util.Optional;

public class ServicioActualizarNombreFranquicia {

    private static final String NO_EXISTE_UNA_FRANQUICIA_CON_EL_ID = "No existe una franquicia con el id %d";

    private final RepositorioFranquicia repositorioFranquicia;

    public ServicioActualizarNombreFranquicia(RepositorioFranquicia repositorioFranquicia) {
        this.repositorioFranquicia = repositorioFranquicia;
    }

    public void ejecutar(Franquicia franquicia) {
        Optional<Franquicia> franquiciaRecuperada = Optional.ofNullable(repositorioFranquicia.obtenerPorId(franquicia.getId()));

        if(franquiciaRecuperada.isEmpty()){
            throw new ExcepcionSinDatos(String.format(NO_EXISTE_UNA_FRANQUICIA_CON_EL_ID, franquicia.getId()));
        }

        repositorioFranquicia.actualizarNombre(franquicia);
    }
}
