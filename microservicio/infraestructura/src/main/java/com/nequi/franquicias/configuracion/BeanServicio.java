package com.nequi.franquicias.configuracion;


import com.nequi.franquicias.franquicia.puerto.repositorio.RepositorioFranquicia;
import com.nequi.franquicias.franquicia.servicio.ServicioCrearFranquicia;
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

} 
