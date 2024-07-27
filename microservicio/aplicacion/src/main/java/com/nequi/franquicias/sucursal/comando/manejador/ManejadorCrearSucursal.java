package com.nequi.franquicias.sucursal.comando.manejador;

import com.nequi.franquicias.ComandoRespuesta;
import com.nequi.franquicias.manejador.ManejadorComandoDatos;
import com.nequi.franquicias.sucursal.comando.ComandoCrearSucursal;
import com.nequi.franquicias.sucursal.comando.fabrica.FabricaCrearSucursal;
import com.nequi.franquicias.sucursal.servicio.ServicioCrearSucursal;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSucursal implements ManejadorComandoDatos<Long, ComandoRespuesta<Long>, ComandoCrearSucursal> {

    private final FabricaCrearSucursal fabricaCrearSucursal;
    private final ServicioCrearSucursal servicioCrearSucursal;

    public ManejadorCrearSucursal(FabricaCrearSucursal fabricaCrearSucursal, ServicioCrearSucursal servicioCrear) {
        this.fabricaCrearSucursal = fabricaCrearSucursal;
        this.servicioCrearSucursal = servicioCrear;
    }


    public ComandoRespuesta<Long> ejecutar(Long idFranquicia, ComandoCrearSucursal comandoCrear) {
        return new ComandoRespuesta<>(servicioCrearSucursal.ejecutar(fabricaCrearSucursal.ejecutar(idFranquicia, comandoCrear)));
    }
}
