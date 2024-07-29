package com.nequi.franquicias.producto.adaptador.dao;

import com.nequi.franquicias.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.nequi.franquicias.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.nequi.franquicias.producto.modelo.dto.ProductoSucursalDTO;
import com.nequi.franquicias.producto.puerto.dao.DaoProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoProductoMySql implements DaoProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoProductoSucursal mapeoProductoSucursal;

    @SqlStatement(namespace = "producto", value = "obtenerproductoconmasstockporsucursal")
    private static String sqlObtenerProductoConMasStockPorSucursal;

    public DaoProductoMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoProductoSucursal mapeoProductoSucursal) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoProductoSucursal = mapeoProductoSucursal;
    }

    @Override
    public List<ProductoSucursalDTO> obtenerProductoConMasStockPorSucursal(Long idFranquicia) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("franquicia_id", idFranquicia);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerProductoConMasStockPorSucursal, paramSource, mapeoProductoSucursal);
    }
}
