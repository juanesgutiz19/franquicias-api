package com.nequi.franquicias.sucursal.modelo.entidad;

import com.nequi.franquicias.franquicia.modelo.entidad.Franquicia;

import static com.nequi.franquicias.dominio.ValidadorArgumento.validarLongitudMinima;
import static com.nequi.franquicias.dominio.ValidadorArgumento.validarObligatorio;

public class Sucursal {

    private static final String NOMBRE_DE_LA_SUCURSAL_ES_REQUERIDO_PARA_CREACION = "El nombre de la sucursal es requerido para su creación";
    private static final String NOMBRE_DE_LA_SUCURSAL_DEBE_TENER_MINIMO_4_CARACTERES = "El nombre de la sucursal debe tener mínimo 4 caracteres";
    private static final String FRANQUICIA_ES_REQUERIDA_PARA_CREACION_DE_LA_SUCURSAL = "La franquicia es requerida para la creación de la sucursal";

    private static final int LONGITUD_MINIMA_NOMBRE_SUCURSAL = 4;

    private Long id;
    private String nombre;
    private Franquicia franquicia;

    public Sucursal(Long id) {
        this.id = id;
    }

    public Sucursal(Long id, String nombre, Franquicia franquicia) {
        this.id = id;
        this.nombre = nombre;
        this.franquicia = franquicia;
    }

    public Sucursal(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Sucursal(String nombre, Franquicia franquicia) {
        this.nombre = nombre;
        this.franquicia = franquicia;
    }

    public static Sucursal crear(Sucursal sucursal) {
        validarObligatorio(sucursal.getNombre(), NOMBRE_DE_LA_SUCURSAL_ES_REQUERIDO_PARA_CREACION);
        validarLongitudMinima(sucursal.getNombre(), LONGITUD_MINIMA_NOMBRE_SUCURSAL, NOMBRE_DE_LA_SUCURSAL_DEBE_TENER_MINIMO_4_CARACTERES);
        validarObligatorio(sucursal.getFranquicia(), FRANQUICIA_ES_REQUERIDA_PARA_CREACION_DE_LA_SUCURSAL);

        return new Sucursal(sucursal.getNombre(), sucursal.getFranquicia());
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

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }
}
