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

    /**
     * Obtiene una Producto por su ID.
     *
     * @param id el ID del Product.
     * @return la entidad Producto encontrada, o null si no existe.
     */
    Producto obtenerPorId(Long id);

    /**
     * Actualiza el nombre del producto.
     *
     * @param producto Toda la entidad Producto.
     */
    void actualizarNombre(Producto producto);

}