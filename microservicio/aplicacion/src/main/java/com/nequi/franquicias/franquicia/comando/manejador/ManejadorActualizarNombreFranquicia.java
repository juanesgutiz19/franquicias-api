package com.nequi.franquicias.franquicia.comando.manejador;

import com.nequi.franquicias.franquicia.comando.ComandoActualizarNombreFranquicia;
import com.nequi.franquicias.franquicia.comando.fabrica.FabricaActualizarNombreFranquicia;
import com.nequi.franquicias.franquicia.servicio.ServicioActualizarNombreFranquicia;
import com.nequi.franquicias.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarNombreFranquicia implements ManejadorComando<ComandoActualizarNombreFranquicia> {

    private final ServicioActualizarNombreFranquicia servicioActualizarNombreFranquicia;
    private final FabricaActualizarNombreFranquicia fabricaActualizarNombreFranquicia;

    public ManejadorActualizarNombreFranquicia(ServicioActualizarNombreFranquicia servicioActualizarNombreFranquicia, FabricaActualizarNombreFranquicia fabricaActualizarNombreFranquicia) {
        this.servicioActualizarNombreFranquicia = servicioActualizarNombreFranquicia;
        this.fabricaActualizarNombreFranquicia = fabricaActualizarNombreFranquicia;
    }

    @Override
    public void ejecutar(ComandoActualizarNombreFranquicia comandoActualizarNombreFranquicia) {
        servicioActualizarNombreFranquicia.
                ejecutar(fabricaActualizarNombreFranquicia.
                        ejecutar(comandoActualizarNombreFranquicia));
    }
}
