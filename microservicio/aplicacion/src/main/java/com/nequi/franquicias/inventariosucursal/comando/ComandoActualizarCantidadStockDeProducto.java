package com.nequi.franquicias.inventariosucursal.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoActualizarCantidadStockDeProducto {
    private Long idSucursal;
    private Long idProducto;
    private Integer cantidadStock;
}
