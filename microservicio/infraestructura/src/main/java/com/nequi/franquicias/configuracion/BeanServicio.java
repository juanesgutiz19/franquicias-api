package com.nequi.franquicias.configuracion;

import com.nequi.franquicias.franquicia.puerto.repositorio.RepositorioFranquicia;
import com.nequi.franquicias.franquicia.servicio.ServicioCrearFranquicia;
import com.nequi.franquicias.inventariosucursal.puerto.repositorio.RepositorioInventarioSucursal;
import com.nequi.franquicias.inventariosucursal.servicio.ServicioAgregarNuevoProductoASucursal;
import com.nequi.franquicias.producto.puerto.repositorio.RepositorioProducto;
import com.nequi.franquicias.sucursal.puerto.repositorio.RepositorioSucursal;
import com.nequi.franquicias.sucursal.servicio.ServicioCrearSucursal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearFranquicia servicioCrearFranquicia(RepositorioFranquicia repositorioFranquicia) {
        return new ServicioCrearFranquicia(repositorioFranquicia);
    }

    @Bean
    public ServicioCrearSucursal servicioCrearSucursal(RepositorioSucursal repositorioSucursal) {
        return new ServicioCrearSucursal(repositorioSucursal);
    }

    @Bean
    public ServicioAgregarNuevoProductoASucursal servicioAgregarNuevoProductoASucursal(RepositorioProducto repositorioProducto,
                                                                                       RepositorioInventarioSucursal repositorioInventarioSucursal) {
        return new ServicioAgregarNuevoProductoASucursal(repositorioProducto, repositorioInventarioSucursal);
    }

} 
