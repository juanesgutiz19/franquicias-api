package com.nequi.franquicias.factura.comando.manejador;

import com.nequi.franquicias.ComandoRespuesta;
import com.nequi.franquicias.factura.comando.ComandoSolicitudFacturar;
import com.nequi.franquicias.factura.comando.fabrica.FabricaSolicitudFacturar;
import com.nequi.franquicias.factura.servicio.ServicioFacturar;
import com.nequi.franquicias.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorFacturar implements ManejadorComandoRespuesta<ComandoSolicitudFacturar, ComandoRespuesta<Long>> {

    private final FabricaSolicitudFacturar fabricaSolicitudFacturar;
    private final ServicioFacturar servicioFacturar;

    public ManejadorFacturar(FabricaSolicitudFacturar fabricaSolicitudFacturar, ServicioFacturar servicioFacturar) {
        this.fabricaSolicitudFacturar = fabricaSolicitudFacturar;
        this.servicioFacturar = servicioFacturar;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudFacturar comandoSolicitudFacturar) {
        return new ComandoRespuesta<>(servicioFacturar
                .ejecutar(fabricaSolicitudFacturar.crear(comandoSolicitudFacturar)));
    }
}
