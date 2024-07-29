package com.nequi.franquicias.sucursal.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoActualizarNombreSucursal {
    private Long id;
    private String nombre;
}
