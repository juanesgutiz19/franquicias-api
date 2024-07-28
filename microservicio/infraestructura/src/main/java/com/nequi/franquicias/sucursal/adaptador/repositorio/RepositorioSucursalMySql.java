package com.nequi.franquicias.sucursal.adaptador.repositorio;

import com.nequi.franquicias.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.nequi.franquicias.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.nequi.franquicias.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.nequi.franquicias.sucursal.modelo.entidad.Sucursal;
import com.nequi.franquicias.sucursal.puerto.repositorio.RepositorioSucursal;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSucursalMySql implements RepositorioSucursal {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoSucursal mapeoSucursal;

    @SqlStatement(namespace = "sucursal", value = "crear")
    private static String sqlCrear;
    @SqlStatement(namespace = "sucursal", value = "obtenerpornombre")
    private static String sqlObtenerPorNombre;
    @SqlStatement(namespace = "sucursal", value = "obtenerporid")
    private static String sqlObtenerPorId;

    public RepositorioSucursalMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoSucursal mapeoSucursal) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoSucursal = mapeoSucursal;
    }

    @Override
    public Long guardar(Sucursal sucursal) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", sucursal.getId());
        paramSource.addValue("nombre", sucursal.getNombre());
        paramSource.addValue("franquicia_id", sucursal.getFranquicia().getId());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }

    @Override
    public Sucursal obtenerPorNombre(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorNombre,
                        paramSource, new MapeoSucursal()));
    }

    @Override
    public Sucursal obtenerPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId,
                        paramSource, new MapeoSucursal()));
    }
}
