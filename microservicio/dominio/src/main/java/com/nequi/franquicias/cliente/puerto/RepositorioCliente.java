package com.nequi.franquicias.cliente.puerto;

import com.nequi.franquicias.cliente.entidad.Cliente;

public interface RepositorioCliente {

    Cliente obtener(Long id);
}
