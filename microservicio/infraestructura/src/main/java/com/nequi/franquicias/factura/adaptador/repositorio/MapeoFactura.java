package com.nequi.franquicias.factura.adaptador.repositorio;

import com.nequi.franquicias.cliente.puerto.RepositorioCliente;
import com.nequi.franquicias.factura.modelo.entidad.EstadoFactura;
import com.nequi.franquicias.factura.modelo.entidad.Factura;
import com.nequi.franquicias.factura.puerto.repositorio.RepositorioProductoFacturar;
import com.nequi.franquicias.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoFactura implements RowMapper<Factura>, MapperResult {

    private final RepositorioCliente repositorioCliente;
    private final RepositorioProductoFacturar repositorioProductoFacturar;

    public MapeoFactura(RepositorioCliente repositorioCliente, RepositorioProductoFacturar repositorioProductoFacturar) {
        this.repositorioCliente = repositorioCliente;
        this.repositorioProductoFacturar = repositorioProductoFacturar;
    }

    @Override
    public Factura mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        long id = resultSet.getLong("id");
        long idCliente = resultSet.getLong("id_cliente");
        BigDecimal valorTotal = resultSet.getBigDecimal("valor_total");
        EstadoFactura estado = EstadoFactura.valueOf(resultSet.getString("estado"));

        return Factura.reconstruir(id, repositorioCliente.obtener(idCliente),
                repositorioProductoFacturar.obtenerPorFactura(id), valorTotal, estado);
    }

}
