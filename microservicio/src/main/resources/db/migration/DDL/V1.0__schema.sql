CREATE TABLE franquicia (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    creado_en TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE sucursal (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    franquicia_id INT NOT NULL,
    creado_en TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (franquicia_id) REFERENCES franquicia(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE producto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    creado_en TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE inventario_sucursal (
    id INT PRIMARY KEY AUTO_INCREMENT,
    sucursal_id INT NOT NULL,
    producto_id INT NOT NULL,
    cantidad_stock INT NOT NULL,
    creado_en TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sucursal_id) REFERENCES sucursal(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (producto_id) REFERENCES producto(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE INDEX idx_nombre_franquicia ON franquicia(nombre);
CREATE INDEX idx_nombre_sucursal ON sucursal(nombre);