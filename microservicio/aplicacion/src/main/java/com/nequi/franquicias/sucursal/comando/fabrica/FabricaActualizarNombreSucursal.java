package com.nequi.franquicias.sucursal.comando.fabrica;

import com.nequi.franquicias.sucursal.comando.ComandoActualizarNombreSucursal;
import com.nequi.franquicias.sucursal.modelo.entidad.Sucursal;
import org.springframework.stereotype.Component;

@Component
public class FabricaActualizarNombreSucursal {

    public Sucursal ejecutar(ComandoActualizarNombreSucursal comandoActualizarNombreSucursal) {
        return new Sucursal(comandoActualizarNombreSucursal.getId(), comandoActualizarNombreSucursal.getNombre());
    }

}