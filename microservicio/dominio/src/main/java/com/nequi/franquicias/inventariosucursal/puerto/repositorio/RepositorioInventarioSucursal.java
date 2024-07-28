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
}