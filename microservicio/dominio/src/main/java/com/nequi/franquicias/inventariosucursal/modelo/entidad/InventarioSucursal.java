package com.nequi.franquicias.inventariosucursal.modelo.entidad;

import com.nequi.franquicias.producto.modelo.entidad.Producto;
import com.nequi.franquicias.sucursal.modelo.entidad.Sucursal;

import static com.nequi.franquicias.dominio.ValidadorArgumento.validarObligatorio;
import static com.nequi.franquicias.dominio.ValidadorArgumento.validarPositivo;

public class InventarioSucursal {

    private static final String SUCURSAL_ID_ES_REQUERIDO = "El ID de la sucursal es requerido";
    private static final String PRODUCTO_ID_ES_REQUERIDO = "El ID del producto es requerido";
    private static final String CANTIDAD_STOCK_DEBE_SER_POSITIVA = "La cantidad de stock debe ser positiva";

    private Long id;
    private Sucursal sucursal;
    private Producto producto;
    private Integer cantidadStock;

    public InventarioSucursal(Long id, Sucursal sucursal, Producto producto, int cantidadStock) {
        this.id = id;
        this.sucursal = sucursal;
        this.producto = producto;
        this.cantidadStock = cantidadStock;
    }

    public InventarioSucursal(Sucursal sucursal, Producto producto, int cantidadStock) {
        this.sucursal = sucursal;
        this.producto = producto;
        this.cantidadStock = cantidadStock;
    }

    public static InventarioSucursal crear(InventarioSucursal inventarioSucursal) {
        validarObligatorio(inventarioSucursal.getSucursal(), SUCURSAL_ID_ES_REQUERIDO);
        validarObligatorio(inventarioSucursal.getProducto(), PRODUCTO_ID_ES_REQUERIDO);
        validarPositivo((double) inventarioSucursal.getCantidadStock(), CANTIDAD_STOCK_DEBE_SER_POSITIVA);
        return new InventarioSucursal(inventarioSucursal.getSucursal(), inventarioSucursal.getProducto(), inventarioSucursal.getCantidadStock());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}