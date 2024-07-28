package com.nequi.franquicias.inventariosucursal.comando.manejador;

import com.nequi.franquicias.inventariosucursal.comando.ComandoActualizarCantidadStockDeProducto;
import com.nequi.franquicias.inventariosucursal.comando.fabrica.FabricaActualizarCantidadStockDeProducto;
import com.nequi.franquicias.inventariosucursal.servicio.ServicioActualizarCantidadStockDeProducto;
import com.nequi.franquicias.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCantidadStockDeProducto implements ManejadorComando<ComandoActualizarCantidadStockDeProducto> {

    private final ServicioActualizarCantidadStockDeProducto servicioActualizarCantidadStockDeProducto;
    private final FabricaActualizarCantidadStockDeProducto fabricaActualizarCantidadStockDeProducto;

    public ManejadorActualizarCantidadStockDeProducto(ServicioActualizarCantidadStockDeProducto servicioActualizarCantidadStockDeProducto, FabricaActualizarCantidadStockDeProducto fabricaActualizarCantidadStockDeProducto) {
        this.servicioActualizarCantidadStockDeProducto = servicioActualizarCantidadStockDeProducto;
        this.fabricaActualizarCantidadStockDeProducto = fabricaActualizarCantidadStockDeProducto;
    }

    @Override
    public void ejecutar(ComandoActualizarCantidadStockDeProducto comandoActualizarCantidadStockDeProducto) {
        servicioActualizarCantidadStockDeProducto
                .ejecutar(fabricaActualizarCantidadStockDeProducto
                        .ejecutar(comandoActualizarCantidadStockDeProducto));
    }
}
