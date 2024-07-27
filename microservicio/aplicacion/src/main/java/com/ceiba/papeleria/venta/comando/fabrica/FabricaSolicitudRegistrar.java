package com.nequi.franquicias.venta.comando.fabrica;

import com.nequi.franquicias.articulo.puerto.repositorio.RepositorioArticulo;
import com.nequi.franquicias.venta.comando.ComandoDetalleVentaRegistrar;
import com.nequi.franquicias.venta.comando.ComandoSolicitudRegistrar;
import com.nequi.franquicias.venta.modelo.entidad.DetalleVenta;
import com.nequi.franquicias.venta.modelo.entidad.SolicitudRegistrar;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FabricaSolicitudRegistrar {

    private final RepositorioArticulo repositorioArticulo;

    public FabricaSolicitudRegistrar(RepositorioArticulo repositorioArticulo) {
        this.repositorioArticulo = repositorioArticulo;
    }

    public SolicitudRegistrar crear(ComandoSolicitudRegistrar comandoSolicitudRegistrar) {
        List<DetalleVenta> detallesVenta = obtenerDetallesVenta(comandoSolicitudRegistrar.getComandoDetallesVentaRegistrar());
        return new SolicitudRegistrar(comandoSolicitudRegistrar.getFecha(),
                detallesVenta
        );
    }

    private List<DetalleVenta> obtenerDetallesVenta(List<ComandoDetalleVentaRegistrar> comandoDetallesVentaRegistrar) {
        return comandoDetallesVentaRegistrar.stream().map(comandoDetalleVenta ->
                        DetalleVenta.crear(
                                comandoDetalleVenta.getCantidad(),
                                repositorioArticulo.obtener(comandoDetalleVenta.getIdArticulo())))
                .collect(Collectors.toList());
    }
}
