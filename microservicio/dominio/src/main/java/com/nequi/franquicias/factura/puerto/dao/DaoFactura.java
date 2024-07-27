package com.nequi.franquicias.factura.puerto.dao;

import com.nequi.franquicias.factura.modelo.dto.ResumenFacturaDTO;

import java.util.List;

public interface DaoFactura {

    List<ResumenFacturaDTO> obtenerResumenDeFacturasAnuladas();
}
