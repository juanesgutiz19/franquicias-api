package com.nequi.franquicias.inventariosucursal.comando.fabrica;

import com.nequi.franquicias.inventariosucursal.comando.ComandoAgregarNuevoProductoASucursal;
import com.nequi.franquicias.inventariosucursal.modelo.entidad.InventarioSucursal;
import com.nequi.franquicias.producto.modelo.entidad.Producto;
import com.nequi.franquicias.sucursal.puerto.repositorio.RepositorioSucursal;
import org.springframework.stereotype.Component;

@Component
public class FabricaAgregarNuevoProductoASucursal {

    public static final int CANTIDAD_STOCK_INICIAL = 0;

    private final RepositorioSucursal repositorioSucursal;

    public FabricaAgregarNuevoProductoASucursal(RepositorioSucursal repositorioSucursal) {
        this.repositorioSucursal = repositorioSucursal;
    }

    public InventarioSucursal ejecutar(Long idSucursal, ComandoAgregarNuevoProductoASucursal comandoAgregarNuevoProductoASucursal) {
        return new InventarioSucursal(repositorioSucursal.obtenerPorId(idSucursal),
                new Producto(comandoAgregarNuevoProductoASucursal.getNombre()), CANTIDAD_STOCK_INICIAL);
    }
}
