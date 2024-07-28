package com.nequi.franquicias.producto.adaptador.repositorio;

import com.nequi.franquicias.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.nequi.franquicias.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.nequi.franquicias.producto.modelo.entidad.Producto;
import com.nequi.franquicias.producto.puerto.repositorio.RepositorioProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioProductoMySql implements RepositorioProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoProducto mapeoProducto;

    public RepositorioProductoMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoProducto mapeoProducto) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoProducto = mapeoProducto;
    }

    @SqlStatement(namespace = "producto", value = "crear")
    private static String sqlCrear;

    @Override
    public Long guardar(Producto producto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", producto.getNombre());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }
}
