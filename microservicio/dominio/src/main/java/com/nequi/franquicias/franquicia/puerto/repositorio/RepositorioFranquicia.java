package com.nequi.franquicias.franquicia.puerto.repositorio;

import com.nequi.franquicias.franquicia.modelo.entidad.Franquicia;

/**
 * RepositorioFranquicia es una interfaz que define las operaciones
 * de persistencia para la entidad Franquicia.
 */
public interface RepositorioFranquicia {

    /**
     * Guarda una nueva entidad Franquicia.
     *
     * @param franquicia la entidad Franquicia a ser guardada.
     * @return el ID de la Franquicia guardada.
     */
    Long guardar(Franquicia franquicia);

    /**
     * Obtiene una Franquicia por su nombre.
     *
     * @param nombre el nombre de la Franquicia.
     * @return la entidad Franquicia encontrada, o null si no existe.
     */
    Franquicia obtenerPorNombre(String nombre);

    /**
     * Obtiene una Franquicia por su ID.
     *
     * @param id el ID de la Franquicia.
     * @return la entidad Franquicia encontrada, o null si no existe.
     */
    Franquicia obtenerPorId(Long id);
}