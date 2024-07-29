package com.nequi.franquicias.franquicia.comando.fabrica;

import com.nequi.franquicias.franquicia.comando.ComandoActualizarNombreFranquicia;
import com.nequi.franquicias.franquicia.modelo.entidad.Franquicia;
import org.springframework.stereotype.Component;

@Component
public class FabricaActualizarNombreFranquicia {

    public Franquicia ejecutar(ComandoActualizarNombreFranquicia comandoActualizarNombreFranquicia) {
        return new Franquicia(comandoActualizarNombreFranquicia.getId(), comandoActualizarNombreFranquicia.getNombre());
    }

}
