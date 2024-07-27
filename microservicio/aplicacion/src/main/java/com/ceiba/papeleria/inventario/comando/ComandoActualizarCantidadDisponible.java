package com.nequi.franquicias.inventario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoActualizarCantidadDisponible {

    private String idArticulo;
    private Integer cantidad;

}
