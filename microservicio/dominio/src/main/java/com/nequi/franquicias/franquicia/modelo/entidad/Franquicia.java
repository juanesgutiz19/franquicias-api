package com.nequi.franquicias.franquicia.modelo.entidad;

import static com.nequi.franquicias.dominio.ValidadorArgumento.validarLongitudMinima;
import static com.nequi.franquicias.dominio.ValidadorArgumento.validarObligatorio;

public class Franquicia {

    private static final String NOMBRE_DE_LA_FRANQUICIA_ES_REQUERIDO_PARA_CREACION = "El nombre de la franquicia es requerido para su creación";
    private static final String NOMBRE_DE_LA_FRANQUICIA_DEBE_TENER_MINIMO_4_CARACTERES = "El nombre de la franquicia debe tener mínimo 4 caracteres";

    private static final int LONGITUD_MINIMA_NOMBRE_FRANQUICIA = 4;

    private Long id;
    private String nombre;

    public Franquicia(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Franquicia(Long id) {
        this.id = id;
    }

    public Franquicia(String nombre) {
        this.nombre = nombre;
    }

    public static Franquicia crear(Franquicia franquicia) {
        validarObligatorio(franquicia.getNombre(), NOMBRE_DE_LA_FRANQUICIA_ES_REQUERIDO_PARA_CREACION);
        validarLongitudMinima(franquicia.getNombre(), LONGITUD_MINIMA_NOMBRE_FRANQUICIA, NOMBRE_DE_LA_FRANQUICIA_DEBE_TENER_MINIMO_4_CARACTERES);
        return new Franquicia(franquicia.getNombre());
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
