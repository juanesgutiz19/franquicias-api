package com.nequi.franquicias.franquicia.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoActualizarNombreFranquicia {
    private Long id;
    private String nombre;
}
