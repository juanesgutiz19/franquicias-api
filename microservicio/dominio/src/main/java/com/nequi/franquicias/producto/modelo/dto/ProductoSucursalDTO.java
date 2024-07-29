package com.nequi.franquicias.producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductoSucursalDTO {
    private Long idProducto;
    private String nombreProducto;
    private Long idSucursal;
    private String nombreSucursal;
    private Integer cantidadStock;
}
