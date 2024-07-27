package com.nequi.franquicias.configuracion;


import com.nequi.franquicias.factura.puerto.repositorio.RepositorioFactura;
import com.nequi.franquicias.factura.servicio.ServicioAnular;
import com.nequi.franquicias.factura.servicio.ServicioFacturar;
import com.nequi.franquicias.inventario.puerto.repositorio.RepositorioInventario;
import com.nequi.franquicias.inventario.servicio.ServicioActualizarCantidadDisponible;
import com.nequi.franquicias.venta.puerto.repositorio.RepositorioVenta;
import com.nequi.franquicias.venta.servicio.ServicioRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioFacturar servicioFacturar(RepositorioFactura repositorioFactura) {
        return new ServicioFacturar(repositorioFactura);
    }

    @Bean
    public ServicioAnular servicioAnular(RepositorioFactura repositorioFactura) {
        return new ServicioAnular(repositorioFactura);
    }

    @Bean
    public ServicioActualizarCantidadDisponible servicioActualizarCantidadDisponible(RepositorioInventario repositorioInventario) {
        return new ServicioActualizarCantidadDisponible(repositorioInventario);
    }

    @Bean
    public ServicioRegistrar servicioRegistrar(RepositorioVenta repositorioVenta) {
        return new ServicioRegistrar(repositorioVenta);
    }

} 
