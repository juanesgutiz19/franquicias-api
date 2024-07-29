package com.nequi.franquicias.configuracion;

import com.nequi.franquicias.franquicia.puerto.repositorio.RepositorioFranquicia;
import com.nequi.franquicias.franquicia.servicio.ServicioActualizarNombreFranquicia;
import com.nequi.franquicias.franquicia.servicio.ServicioCrearFranquicia;
import com.nequi.franquicias.inventariosucursal.puerto.repositorio.RepositorioInventarioSucursal;
import com.nequi.franquicias.inventariosucursal.servicio.ServicioActualizarCantidadStockDeProducto;
import com.nequi.franquicias.inventariosucursal.servicio.ServicioAgregarNuevoProductoASucursal;
import com.nequi.franquicias.inventariosucursal.servicio.ServicioEliminarProductoASucursal;
import com.nequi.franquicias.inventariosucursal.servicio.ServicioValidarSucursalYProducto;
import com.nequi.franquicias.producto.puerto.dao.DaoProducto;
import com.nequi.franquicias.producto.puerto.repositorio.RepositorioProducto;
import com.nequi.franquicias.producto.servicio.ServicioActualizarNombreProducto;
import com.nequi.franquicias.producto.servicio.ServicioObtenerProductoConMasStockPorSucursal;
import com.nequi.franquicias.sucursal.puerto.repositorio.RepositorioSucursal;
import com.nequi.franquicias.sucursal.servicio.ServicioActualizarNombreSucursal;
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

    @Bean
    public ServicioEliminarProductoASucursal servicioEliminarProductoASucursal(RepositorioInventarioSucursal repositorioInventarioSucursal, ServicioValidarSucursalYProducto servicioValidarSucursalYProducto) {
        return new ServicioEliminarProductoASucursal(repositorioInventarioSucursal, servicioValidarSucursalYProducto);
    }

    @Bean
    public ServicioValidarSucursalYProducto servicioValidarSucursalYProducto(RepositorioSucursal repositorioSucursal,
                                                                             RepositorioProducto repositorioProducto,
                                                                             RepositorioInventarioSucursal repositorioInventarioSucursal) {
        return new ServicioValidarSucursalYProducto(repositorioSucursal, repositorioProducto, repositorioInventarioSucursal);
    }

    @Bean
    public ServicioActualizarCantidadStockDeProducto servicioActualizarCantidadStockDeProducto(RepositorioInventarioSucursal repositorioInventarioSucursal,
                                                                                               ServicioValidarSucursalYProducto servicioValidarSucursalYProducto) {
        return new ServicioActualizarCantidadStockDeProducto(repositorioInventarioSucursal, servicioValidarSucursalYProducto);
    }

    @Bean
    public ServicioObtenerProductoConMasStockPorSucursal servicioObtenerProductoConMasStockPorSucursal(RepositorioFranquicia repositorioFranquicia,
                                                                                                       DaoProducto daoProducto) {
        return new ServicioObtenerProductoConMasStockPorSucursal(repositorioFranquicia, daoProducto);
    }

    @Bean
    public ServicioActualizarNombreFranquicia servicioActualizarNombreFranquicia(RepositorioFranquicia repositorioFranquicia) {
        return new ServicioActualizarNombreFranquicia(repositorioFranquicia);
    }

    @Bean
    public ServicioActualizarNombreSucursal servicioActualizarNombreSucursal(RepositorioSucursal repositorioSucursal) {
        return new ServicioActualizarNombreSucursal(repositorioSucursal);
    }

    @Bean
    public ServicioActualizarNombreProducto servicioActualizarNombreProducto(RepositorioProducto repositorioProducto) {
        return new ServicioActualizarNombreProducto(repositorioProducto);
    }

} 
