package com.nequi.franquicias.inventariosucursal.adaptador.repositorio;

import com.nequi.franquicias.infraestructura.jdbc.MapperResult;
import com.nequi.franquicias.inventariosucursal.modelo.entidad.InventarioSucursal;
import com.nequi.franquicias.producto.modelo.entidad.Producto;
import com.nequi.franquicias.sucursal.modelo.entidad.Sucursal;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoInventarioSucursal implements RowMapper<InventarioSucursal>, MapperResult {

    @Override
    public InventarioSucursal mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        long id = resultSet.getLong("id");
        long idSucursal = resultSet.getLong("sucursal_id");
        long idProducto = resultSet.getLong("producto_id");
        int cantidadStock = resultSet.getInt("cantidad_stock");

        return new InventarioSucursal(id, new Sucursal(idSucursal), new Producto(idProducto), cantidadStock);
    }
}
