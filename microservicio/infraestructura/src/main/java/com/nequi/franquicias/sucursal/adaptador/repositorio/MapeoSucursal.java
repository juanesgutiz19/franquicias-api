package com.nequi.franquicias.sucursal.adaptador.repositorio;

import com.nequi.franquicias.franquicia.modelo.entidad.Franquicia;
import com.nequi.franquicias.infraestructura.jdbc.MapperResult;
import com.nequi.franquicias.sucursal.modelo.entidad.Sucursal;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoSucursal implements RowMapper<Sucursal>, MapperResult {

    @Override
    public Sucursal mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        long idFranquicia = resultSet.getLong("franquicia_id");

        return new Sucursal(id, nombre, new Franquicia(idFranquicia));
    }
}
