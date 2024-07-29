package com.nequi.franquicias.producto.puerto.dao;

import com.nequi.franquicias.producto.modelo.dto.ProductoSucursalDTO;

import java.util.List;

/**
 * Interfaz para el acceso a datos de productos.
 */
public interface DaoProducto {

    /**
     * Obtiene una lista de productos con el mayor stock por cada sucursal
     * de una franquicia específica.
     *
     * @param idFranquicia el identificador de la franquicia con el cual se identifican las sucursales
     * @return una lista de {@link ProductoSucursalDTO} que contiene la información de los productos
     * con el mayor stock por sucursal, incluyendo el nombre de la sucursal y el stock del producto
     */
    List<ProductoSucursalDTO> obtenerProductoConMasStockPorSucursal(Long idFranquicia);
}
