package com.nequi.franquicias.inventariosucursal.comando.fabrica;

import com.nequi.franquicias.inventariosucursal.comando.ComandoActualizarCantidadStockDeProducto;
import com.nequi.franquicias.inventariosucursal.modelo.entidad.InventarioSucursal;
import com.nequi.franquicias.producto.modelo.entidad.Producto;
import com.nequi.franquicias.sucursal.modelo.entidad.Sucursal;
import org.springframework.stereotype.Component;

@Component
public class FabricaActualizarCantidadStockDeProducto {

    public InventarioSucursal ejecutar(ComandoActualizarCantidadStockDeProducto comandoActualizarCantidadStockDeProducto) {
        return new InventarioSucursal(
                new Sucursal(comandoActualizarCantidadStockDeProducto.getIdSucursal()),
                new Producto(comandoActualizarCantidadStockDeProducto.getIdProducto()),
                comandoActualizarCantidadStockDeProducto.getCantidadStock()
        );
    }
}
