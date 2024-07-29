package com.nequi.franquicias.sucursal.puerto.repositorio;

import com.nequi.franquicias.sucursal.modelo.entidad.Sucursal;

/**
 * RepositorioSucursal es una interfaz que define las operaciones
 * de persistencia para la entidad Sucursal.
 */
public interface RepositorioSucursal {

    /**
     * Guarda una nueva entidad Sucursal en el repositorio.
     *
     * @param sucursal la entidad Sucursal a ser guardada.
     * @return el ID de la Sucursal guardada.
     */
    Long guardar(Sucursal sucursal);

    /**
     * Obtiene una Sucursal por su nombre.
     *
     * @param nombre el nombre de la Sucursal.
     * @return la entidad Sucursal encontrada, o null si no existe.
     */
    Sucursal obtenerPorNombre(String nombre);

    /**
     * Obtiene una Sucursal por su ID.
     *
     * @param id el ID de la Sucursal.
     * @return la entidad Sucursal encontrada, o null si no existe.
     */
    Sucursal obtenerPorId(Long id);

    /**
     * Actualiza el nombre de la sucursal.
     *
     * @param sucursal Toda la entidad Franquicia.
     */
    void actualizarNombre(Sucursal sucursal);
}