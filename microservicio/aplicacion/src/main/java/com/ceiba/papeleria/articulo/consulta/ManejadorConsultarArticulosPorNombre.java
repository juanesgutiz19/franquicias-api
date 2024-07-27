package com.nequi.franquicias.articulo.consulta;

import com.nequi.franquicias.articulo.modelo.dto.ArticuloDTO;
import com.nequi.franquicias.articulo.puerto.dao.DaoArticulo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarArticulosPorNombre {

    private final DaoArticulo daoArticulo;

    public ManejadorConsultarArticulosPorNombre(DaoArticulo daoArticulo) {
        this.daoArticulo = daoArticulo;
    }

    public List<ArticuloDTO> ejecutar(String nombre) {
        return daoArticulo.obtenerArticulosPorNombre(nombre);
    }

}
