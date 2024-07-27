package com.nequi.franquicias.franquicia.comando.manejador;

import com.nequi.franquicias.ComandoRespuesta;
import com.nequi.franquicias.franquicia.comando.ComandoCrearFranquicia;
import com.nequi.franquicias.franquicia.comando.fabrica.FabricaCrearFranquicia;
import com.nequi.franquicias.franquicia.servicio.ServicioCrearFranquicia;
import com.nequi.franquicias.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearFranquicia implements ManejadorComandoRespuesta<ComandoCrearFranquicia, ComandoRespuesta<Long>> {

    private final FabricaCrearFranquicia fabricaCrearFranquicia;
    private final ServicioCrearFranquicia servicioCrearFranquicia;

    public ManejadorCrearFranquicia(FabricaCrearFranquicia fabricaCrearFranquicia, ServicioCrearFranquicia servicioCrearFranquicia) {
        this.fabricaCrearFranquicia = fabricaCrearFranquicia;
        this.servicioCrearFranquicia = servicioCrearFranquicia;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoCrearFranquicia comandoCrear) {
        return new ComandoRespuesta<>(servicioCrearFranquicia.ejecutar(fabricaCrearFranquicia.ejecutar(comandoCrear)));
    }
}
