package com.nequi.franquicias.sucursal.comando.fabrica;

import com.nequi.franquicias.franquicia.puerto.repositorio.RepositorioFranquicia;
import com.nequi.franquicias.sucursal.comando.ComandoCrearSucursal;
import com.nequi.franquicias.sucursal.modelo.entidad.Sucursal;
import org.springframework.stereotype.Component;

@Component
public class FabricaCrearSucursal {

    private final RepositorioFranquicia repositorioFranquicia;

    public FabricaCrearSucursal(RepositorioFranquicia repositorioFranquicia) {
        this.repositorioFranquicia = repositorioFranquicia;
    }

    public Sucursal ejecutar(Long idFranquicia, ComandoCrearSucursal comandoCrear) {
        return new Sucursal(comandoCrear.getNombre(), repositorioFranquicia.obtenerPorId(idFranquicia));
    }

}
