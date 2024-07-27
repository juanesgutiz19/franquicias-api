package com.nequi.franquicias.articulo.adaptador.dao;

import com.nequi.franquicias.articulo.modelo.dto.ArticuloDTO;
import com.nequi.franquicias.articulo.puerto.dao.DaoArticulo;
import com.nequi.franquicias.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.nequi.franquicias.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoArticuloMysql implements DaoArticulo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoArticulo mapeoArticulo;

    @SqlStatement(namespace = "articulo", value = "obtenerpornombre")
    private static String sqlObtenerPorNombre;

    public DaoArticuloMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoArticulo mapeoArticulo) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoArticulo = mapeoArticulo;
    }

    @Override
    public List<ArticuloDTO> obtenerArticulosPorNombre(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerPorNombre, paramSource, mapeoArticulo);
    }

}
