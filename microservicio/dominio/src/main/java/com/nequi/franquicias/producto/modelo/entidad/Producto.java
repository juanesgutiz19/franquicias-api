package com.nequi.franquicias.producto.modelo.entidad;

import static com.nequi.franquicias.dominio.ValidadorArgumento.validarLongitudMinima;
import static com.nequi.franquicias.dominio.ValidadorArgumento.validarObligatorio;

public class Producto {

    private static final String NOMBRE_DEL_PRODUCTO_ES_REQUERIDO_PARA_CREACION = "El nombre del producto es requerido para su creación";
    private static final String NOMBRE_DEL_PRODUCTO_DEBE_TENER_MINIMO_4_CARACTERES = "El nombre del producto debe tener mínimo 4 caracteres";

    private static final int LONGITUD_MINIMA_NOMBRE_PRODUCTO = 4;

    private Long id;
    private String nombre;

    public Producto(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Producto(Long id) {
        this.id = id;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public static Producto crear(Producto producto) {
        validarObligatorio(producto.getNombre(), NOMBRE_DEL_PRODUCTO_ES_REQUERIDO_PARA_CREACION);
        validarLongitudMinima(producto.getNombre(), LONGITUD_MINIMA_NOMBRE_PRODUCTO, NOMBRE_DEL_PRODUCTO_DEBE_TENER_MINIMO_4_CARACTERES);
        return new Producto(producto.getNombre());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}