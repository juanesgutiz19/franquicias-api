package com.nequi.franquicias.producto.puerto.repositorio;

import com.nequi.franquicias.producto.modelo.entidad.Producto;

/**
 * RepositorioProducto es una interfaz que define las operaciones
 * de persistencia para la entidad Producto.
 */
public interface RepositorioProducto {

    /**
     * Guarda una nueva entidad Producto.
     *
     * @param producto la entidad Producto a ser guardada.
     * @return el ID del Producto guardado.
     */
    Long guardar(Producto producto);
}