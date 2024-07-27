package com.nequi.franquicias.franquicia.comando.fabrica;

import com.nequi.franquicias.franquicia.comando.ComandoCrearFranquicia;
import com.nequi.franquicias.franquicia.modelo.entidad.Franquicia;
import org.springframework.stereotype.Component;

@Component
public class FabricaCrearFranquicia {

    public Franquicia ejecutar(ComandoCrearFranquicia comandoCrear) {
        return new Franquicia(comandoCrear.getNombre());
    }
}
