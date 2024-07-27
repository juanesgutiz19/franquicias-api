package com.nequi.franquicias.factura.adaptador.dao;

import com.nequi.franquicias.factura.modelo.dto.ResumenFacturaDTO;
import com.nequi.franquicias.factura.puerto.dao.DaoFactura;
import com.nequi.franquicias.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.nequi.franquicias.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoFacturaMysql implements DaoFactura {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoFacturaResumen mapeoFacturaResumen;

    @SqlStatement(namespace = "factura", value = "obteneranuladas")
    private static String sqlObtenerAnuladas;

    public DaoFacturaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoFacturaResumen mapeoFacturaResumen) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoFacturaResumen = mapeoFacturaResumen;
    }

    @Override
    public List<ResumenFacturaDTO> obtenerResumenDeFacturasAnuladas() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerAnuladas, mapeoFacturaResumen);
    }
}
