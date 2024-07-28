package com.nequi.franquicias.inventariosucursal.comando.manejador;

import com.nequi.franquicias.ComandoRespuesta;
import com.nequi.franquicias.inventariosucursal.comando.ComandoAgregarNuevoProductoASucursal;
import com.nequi.franquicias.inventariosucursal.comando.fabrica.FabricaAgregarNuevoProductoASucursal;
import com.nequi.franquicias.inventariosucursal.servicio.ServicioAgregarNuevoProductoASucursal;
import com.nequi.franquicias.manejador.ManejadorComandoDatos;
import org.springframework.stereotype.Component;

@Component
public class ManejadorAgregarNuevoProductoASucursal implements ManejadorComandoDatos<Long, ComandoRespuesta<Long>, ComandoAgregarNuevoProductoASucursal> {

    private final FabricaAgregarNuevoProductoASucursal fabricaAgregarNuevoProductoASucursal;
    private final ServicioAgregarNuevoProductoASucursal servicioAgregarNuevoProductoASucursal;

    public ManejadorAgregarNuevoProductoASucursal(FabricaAgregarNuevoProductoASucursal fabricaAgregarNuevoProductoASucursal, ServicioAgregarNuevoProductoASucursal servicioAgregarNuevoProductoASucursal) {
        this.fabricaAgregarNuevoProductoASucursal = fabricaAgregarNuevoProductoASucursal;
        this.servicioAgregarNuevoProductoASucursal = servicioAgregarNuevoProductoASucursal;
    }

    public ComandoRespuesta<Long> ejecutar(Long idSucursal,
                                           ComandoAgregarNuevoProductoASucursal comandoAgregarNuevoProductoASucursal) {
        return new ComandoRespuesta<>(servicioAgregarNuevoProductoASucursal
                .ejecutar(fabricaAgregarNuevoProductoASucursal
                .ejecutar(idSucursal, comandoAgregarNuevoProductoASucursal)));
    }
}
