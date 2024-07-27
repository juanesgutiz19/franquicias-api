package com.nequi.franquicias.articulo.adaptador.repositorio;

import com.nequi.franquicias.articulo.modelo.entidad.Articulo;
import com.nequi.franquicias.articulo.puerto.repositorio.RepositorioArticulo;
import com.nequi.franquicias.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.nequi.franquicias.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.nequi.franquicias.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioArticuloMySql implements RepositorioArticulo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "articulo", value = "obtenerporcodigo")
    private static String sqlObtenerPorCodigo;

    public RepositorioArticuloMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Articulo obtener(String codigo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("codigo", codigo);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorCodigo,
                        paramSource, new MapeoArticulo()));
    }
}
