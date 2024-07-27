package com.nequi.franquicias.articulo.adaptador.repositorio;

import com.nequi.franquicias.articulo.modelo.entidad.Articulo;
import com.nequi.franquicias.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoArticulo implements RowMapper<Articulo>, MapperResult {
    @Override
    public Articulo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        String codigo = resultSet.getString("codigo");
        String nombre = resultSet.getString("nombre");
        BigDecimal precioCompra = resultSet.getBigDecimal("precio_compra");
        BigDecimal precioVenta = resultSet.getBigDecimal("precio_venta");

        return Articulo.reconstruir(codigo, nombre, precioCompra, precioVenta);
    }
}
