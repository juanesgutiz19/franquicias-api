package com.nequi.franquicias.sucursal.comando.manejador;

import com.nequi.franquicias.manejador.ManejadorComando;
import com.nequi.franquicias.sucursal.comando.ComandoActualizarNombreSucursal;
import com.nequi.franquicias.sucursal.comando.fabrica.FabricaActualizarNombreSucursal;
import com.nequi.franquicias.sucursal.servicio.ServicioActualizarNombreSucursal;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarNombreSucursal implements ManejadorComando<ComandoActualizarNombreSucursal> {

    private final ServicioActualizarNombreSucursal servicioActualizarNombreSucursal;
    private final FabricaActualizarNombreSucursal fabricaActualizarNombreSucursal;

    public ManejadorActualizarNombreSucursal(ServicioActualizarNombreSucursal servicioActualizarNombreSucursal, FabricaActualizarNombreSucursal fabricaActualizarNombreSucursal) {
        this.servicioActualizarNombreSucursal = servicioActualizarNombreSucursal;
        this.fabricaActualizarNombreSucursal = fabricaActualizarNombreSucursal;
    }

    @Override
    public void ejecutar(ComandoActualizarNombreSucursal comandoActualizarNombreSucursal) {
        servicioActualizarNombreSucursal.ejecutar(fabricaActualizarNombreSucursal.ejecutar(comandoActualizarNombreSucursal));
    }
}
