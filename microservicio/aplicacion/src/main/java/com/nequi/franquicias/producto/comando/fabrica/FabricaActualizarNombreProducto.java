package com.nequi.franquicias.producto.comando.fabrica;

import com.nequi.franquicias.producto.comando.ComandoActualizarNombreProducto;
import com.nequi.franquicias.producto.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaActualizarNombreProducto {

    public Producto ejecutar(ComandoActualizarNombreProducto comandoActualizarNombreProducto) {
        return new Producto(comandoActualizarNombreProducto.getId(), comandoActualizarNombreProducto.getNombre());
    }

}