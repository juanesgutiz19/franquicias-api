package com.nequi.franquicias.franquicia.adaptador.repositorio;

import com.nequi.franquicias.franquicia.modelo.entidad.Franquicia;
import com.nequi.franquicias.franquicia.puerto.repositorio.RepositorioFranquicia;
import com.nequi.franquicias.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.nequi.franquicias.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.nequi.franquicias.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioFranquiciaMySql implements RepositorioFranquicia {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoFranquicia mapeoFranquicia;

    @SqlStatement(namespace = "franquicia", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "franquicia", value = "obtenerpornombre")
    private static String sqlObtenerPorNombre;

    @SqlStatement(namespace = "franquicia", value = "obtenerporid")
    private static String sqlObtenerPorId;

    public RepositorioFranquiciaMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoFranquicia mapeoFranquicia) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoFranquicia = mapeoFranquicia;
    }

    @Override
    public Long guardar(Franquicia franquicia) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", franquicia.getId());
        paramSource.addValue("nombre", franquicia.getNombre());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }

    @Override
    public Franquicia obtenerPorNombre(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorNombre,
                        paramSource, new MapeoFranquicia()));
    }

    @Override
    public Franquicia obtenerPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId,
                        paramSource, new MapeoFranquicia()));
    }
}
