package com.nequi.franquicias.producto.adaptador.dao;

import com.nequi.franquicias.infraestructura.jdbc.MapperResult;
import com.nequi.franquicias.producto.modelo.dto.ProductoSucursalDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoProductoSucursal implements RowMapper<ProductoSucursalDTO>, MapperResult {

    @Override
    public ProductoSucursalDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idProducto = resultSet.getLong("producto_id");
        String nombreProducto = resultSet.getString("producto_nombre");
        Long idSucursal = resultSet.getLong("sucursal_id");
        String nombreSucursal = resultSet.getString("sucursal_nombre");
        Integer cantidadStock = resultSet.getInt("cantidad_stock");

        return new ProductoSucursalDTO(idProducto, nombreProducto, idSucursal, nombreSucursal, cantidadStock);
    }
}
