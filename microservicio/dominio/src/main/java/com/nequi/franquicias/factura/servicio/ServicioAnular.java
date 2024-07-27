package com.nequi.franquicias.factura.servicio;

import com.nequi.franquicias.dominio.ValidadorArgumento;
import com.nequi.franquicias.factura.modelo.entidad.Factura;
import com.nequi.franquicias.factura.puerto.repositorio.RepositorioFactura;

public class ServicioAnular {

    private final RepositorioFactura repositorioFactura;

    public ServicioAnular(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public void ejecutar(Factura factura) {
        ValidadorArgumento.validarObligatorio(factura, "No existe una factura para anular");
        factura.anular();
        repositorioFactura.actualizarEstado(factura);
    }
}
