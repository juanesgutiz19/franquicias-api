package com.nequi.franquicias.inventariosucursal.adaptador.repositorio;

import com.nequi.franquicias.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.nequi.franquicias.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.nequi.franquicias.inventariosucursal.modelo.entidad.InventarioSucursal;
import com.nequi.franquicias.inventariosucursal.puerto.repositorio.RepositorioInventarioSucursal;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioInventarioSucursalMySql implements RepositorioInventarioSucursal {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoInventarioSucursal mapeoInventarioSucursal;

    @SqlStatement(namespace = "inventariosucursal", value = "crear")
    private static String sqlCrear;

    public RepositorioInventarioSucursalMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoInventarioSucursal mapeoInventarioSucursal) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoInventarioSucursal = mapeoInventarioSucursal;
    }

    @Override
    public Long guardar(InventarioSucursal inventarioSucursal) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("sucursal_id", inventarioSucursal.getSucursal().getId());
        paramSource.addValue("producto_id", inventarioSucursal.getProducto().getId());
        paramSource.addValue("cantidad_stock", inventarioSucursal.getCantidadStock());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }
}
