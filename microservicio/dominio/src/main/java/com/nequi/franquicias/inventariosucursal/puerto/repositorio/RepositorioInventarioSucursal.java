package com.nequi.franquicias.inventariosucursal.puerto.repositorio;

import com.nequi.franquicias.inventariosucursal.modelo.entidad.InventarioSucursal;

/**
 * RepositorioInventarioSucursal es una interfaz que define las operaciones
 * de persistencia para la entidad InventarioSucursal.
 */
public interface RepositorioInventarioSucursal {

    /**
     * Guarda una nueva entidad InventarioSucursal.
     *
     * @param inventarioSucursal la entidad InventarioSucursal a ser guardada.
     * @return el ID del InventarioSucursal guardado.
     */
    Long guardar(InventarioSucursal inventarioSucursal);

    /**
     * Elimina una entidad InventarioSucursal basada en la sucursal y el producto.
     *
     * @param sucursalId el ID de la sucursal.
     * @param productoId el ID del producto.
     */
    void eliminarPorSucursalYProducto(Long sucursalId, Long productoId);

    /**
     * Obtiene una InventarioSucursal por su sucursalId y productoId.
     *
     * @param sucursalId el ID del Product.
     * @return la entidad Producto encontrada, o null si no existe.
     */
    InventarioSucursal obtenerPorSucursalYProducto(Long sucursalId, Long productoId);
}