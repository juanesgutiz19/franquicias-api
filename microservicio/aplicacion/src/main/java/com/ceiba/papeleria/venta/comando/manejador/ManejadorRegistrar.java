package com.nequi.franquicias.venta.comando.manejador;

import com.nequi.franquicias.ComandoRespuesta;
import com.nequi.franquicias.manejador.ManejadorComandoRespuesta;
import com.nequi.franquicias.venta.comando.ComandoSolicitudRegistrar;
import com.nequi.franquicias.venta.comando.fabrica.FabricaSolicitudRegistrar;
import com.nequi.franquicias.venta.servicio.ServicioRegistrar;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRegistrar implements ManejadorComandoRespuesta<ComandoSolicitudRegistrar, ComandoRespuesta<Long>> {

    private final FabricaSolicitudRegistrar fabricaSolicitudRegistrar;
    private final ServicioRegistrar servicioRegistrar;

    public ManejadorRegistrar(FabricaSolicitudRegistrar fabricaSolicitudRegistrar, ServicioRegistrar servicioRegistrar) {
        this.fabricaSolicitudRegistrar = fabricaSolicitudRegistrar;
        this.servicioRegistrar = servicioRegistrar;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudRegistrar comandoSolicitudRegistrar) {
        return new ComandoRespuesta<>(servicioRegistrar
                .ejecutar(fabricaSolicitudRegistrar.crear(comandoSolicitudRegistrar)));
    }
}
