CREATE TABLE franquicia (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE sucursal (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    franquicia_id INT,
    FOREIGN KEY (franquicia_id) REFERENCES franquicia(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE producto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE inventario_sucursal (
    id INT PRIMARY KEY AUTO_INCREMENT,
    sucursal_id INT,
    producto_id INT,
    cantidad_stock INT NOT NULL,
    FOREIGN KEY (sucursal_id) REFERENCES sucursal(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (producto_id) REFERENCES producto(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);