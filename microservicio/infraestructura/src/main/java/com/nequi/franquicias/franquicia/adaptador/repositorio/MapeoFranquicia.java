package com.nequi.franquicias.franquicia.adaptador.repositorio;

import com.nequi.franquicias.franquicia.modelo.entidad.Franquicia;
import com.nequi.franquicias.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoFranquicia implements RowMapper<Franquicia>, MapperResult {

    @Override
    public Franquicia mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");

        return new Franquicia(id, nombre);
    }
}
