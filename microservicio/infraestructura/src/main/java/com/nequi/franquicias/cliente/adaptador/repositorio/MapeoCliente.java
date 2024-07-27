package com.nequi.franquicias.cliente.adaptador.repositorio;

import com.nequi.franquicias.cliente.entidad.Cliente;
import com.nequi.franquicias.cliente.entidad.TipoCliente;
import com.nequi.franquicias.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCliente implements RowMapper<Cliente>, MapperResult {

    @Override
    public Cliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        TipoCliente tipoCliente = TipoCliente.valueOf(resultSet.getString("tipo_cliente"));

        return Cliente.reconstruir(id, nombre, tipoCliente);
    }

}
