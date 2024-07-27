package com.nequi.franquicias.cliente.adaptador.repositorio;

import com.nequi.franquicias.cliente.entidad.Cliente;
import com.nequi.franquicias.cliente.puerto.RepositorioCliente;
import com.nequi.franquicias.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.nequi.franquicias.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.nequi.franquicias.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClienteMysql implements RepositorioCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "cliente", value = "obtenerporid")
    private static String sqlObtenerPorId;

    public RepositorioClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Cliente obtener(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId,
                        paramSource, new MapeoCliente()));
    }

}
