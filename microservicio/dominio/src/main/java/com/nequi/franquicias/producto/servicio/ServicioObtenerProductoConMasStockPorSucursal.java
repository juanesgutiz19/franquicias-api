package com.nequi.franquicias.producto.servicio;

import com.nequi.franquicias.dominio.excepcion.ExcepcionSinDatos;
import com.nequi.franquicias.franquicia.modelo.entidad.Franquicia;
import com.nequi.franquicias.franquicia.puerto.repositorio.RepositorioFranquicia;
import com.nequi.franquicias.producto.modelo.dto.ProductoSucursalDTO;
import com.nequi.franquicias.producto.puerto.dao.DaoProducto;

import java.util.List;
import java.util.Optional;

public class ServicioObtenerProductoConMasStockPorSucursal {

    private static final String NO_EXISTE_UNA_FRANQUICIA_CON_EL_ID = "No existe una franquicia con el id %d";

    private final RepositorioFranquicia repositorioFranquicia;
    private final DaoProducto daoProducto;

    public ServicioObtenerProductoConMasStockPorSucursal(RepositorioFranquicia repositorioFranquicia, DaoProducto daoProducto) {
        this.repositorioFranquicia = repositorioFranquicia;
        this.daoProducto = daoProducto;
    }

    public List<ProductoSucursalDTO> ejecutar(Long idFranquicia) {

        Optional<Franquicia> franquicia = Optional.ofNullable(repositorioFranquicia.obtenerPorId(idFranquicia));

        if (franquicia.isEmpty()) {
            throw new ExcepcionSinDatos(String.format(NO_EXISTE_UNA_FRANQUICIA_CON_EL_ID, idFranquicia));
        }

        return daoProducto.obtenerProductoConMasStockPorSucursal(idFranquicia);
    }
}
