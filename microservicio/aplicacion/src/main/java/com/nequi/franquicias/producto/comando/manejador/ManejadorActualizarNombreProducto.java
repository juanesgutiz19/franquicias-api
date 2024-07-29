package com.nequi.franquicias.producto.comando.manejador;

import com.nequi.franquicias.manejador.ManejadorComando;
import com.nequi.franquicias.producto.comando.ComandoActualizarNombreProducto;
import com.nequi.franquicias.producto.comando.fabrica.FabricaActualizarNombreProducto;
import com.nequi.franquicias.producto.servicio.ServicioActualizarNombreProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarNombreProducto implements ManejadorComando<ComandoActualizarNombreProducto> {

    private final ServicioActualizarNombreProducto servicioActualizarNombreProducto;
    private final FabricaActualizarNombreProducto fabricaActualizarNombreProducto;

    public ManejadorActualizarNombreProducto(ServicioActualizarNombreProducto servicioActualizarNombreProducto, FabricaActualizarNombreProducto fabricaActualizarNombreProducto) {
        this.servicioActualizarNombreProducto = servicioActualizarNombreProducto;
        this.fabricaActualizarNombreProducto = fabricaActualizarNombreProducto;
    }

    @Override
    public void ejecutar(ComandoActualizarNombreProducto comandoActualizarNombreProducto) {
        servicioActualizarNombreProducto.ejecutar(fabricaActualizarNombreProducto.ejecutar(comandoActualizarNombreProducto));
    }
}
