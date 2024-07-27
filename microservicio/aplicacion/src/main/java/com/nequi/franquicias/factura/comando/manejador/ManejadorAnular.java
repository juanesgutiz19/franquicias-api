package com.nequi.franquicias.factura.comando.manejador;

import com.nequi.franquicias.factura.comando.ComandoAnular;
import com.nequi.franquicias.factura.puerto.repositorio.RepositorioFactura;
import com.nequi.franquicias.factura.servicio.ServicioAnular;
import com.nequi.franquicias.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorAnular implements ManejadorComando<ComandoAnular> {

    private final ServicioAnular servicioAnular;
    private final RepositorioFactura repositorioFactura;

    public ManejadorAnular(ServicioAnular servicioAnular, RepositorioFactura repositorioFactura) {
        this.servicioAnular = servicioAnular;
        this.repositorioFactura = repositorioFactura;
    }

    @Override
    public void ejecutar(ComandoAnular comandoAnular) {
        servicioAnular.ejecutar(repositorioFactura.obtener(comandoAnular.getIdFactura()));
    }
}
