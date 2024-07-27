package com.nequi.franquicias.franquicia.servicio;

import com.nequi.franquicias.dominio.excepcion.ExcepcionDuplicidad;
import com.nequi.franquicias.franquicia.modelo.entidad.Franquicia;
import com.nequi.franquicias.franquicia.puerto.repositorio.RepositorioFranquicia;

import java.util.Optional;

public class ServicioCrearFranquicia {

    public static final String YA_EXISTE_UNA_FRANQUICIA_CON_EL_NOMBRE_INGRESADO = "Ya existe una franquicia con el nombre %s";

    private final RepositorioFranquicia repositorioFranquicia;

    public ServicioCrearFranquicia(RepositorioFranquicia repositorioFranquicia) {
        this.repositorioFranquicia = repositorioFranquicia;
    }

    public Long ejecutar(Franquicia franquicia) {
        Optional<Franquicia> franquiciaObtenida = Optional.ofNullable(repositorioFranquicia.obtenerPorNombre(franquicia.getNombre()));
        if (franquiciaObtenida.isPresent()) {
            throw new ExcepcionDuplicidad(String.format(YA_EXISTE_UNA_FRANQUICIA_CON_EL_NOMBRE_INGRESADO, franquicia.getNombre()));
        }

        return repositorioFranquicia.guardar(Franquicia.crear(franquicia));
    }
}
