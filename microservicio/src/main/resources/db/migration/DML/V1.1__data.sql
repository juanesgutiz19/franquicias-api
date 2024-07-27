INSERT INTO franquicia (nombre) VALUES ('Electrónica Mundial');
INSERT INTO franquicia (nombre) VALUES ('Librería Central');
INSERT INTO franquicia (nombre) VALUES ('Delicias Gourmet');

INSERT INTO sucursal (nombre, franquicia_id) VALUES ('Electrónica Mundial - Centro', 1);
INSERT INTO sucursal (nombre, franquicia_id) VALUES ('Electrónica Mundial - Norte', 1);
INSERT INTO sucursal (nombre, franquicia_id) VALUES ('Librería Central - Centro', 2);
INSERT INTO sucursal (nombre, franquicia_id) VALUES ('Librería Central - Sur', 2);
INSERT INTO sucursal (nombre, franquicia_id) VALUES ('Delicias Gourmet - Este', 3);
INSERT INTO sucursal (nombre, franquicia_id) VALUES ('Delicias Gourmet - Oeste', 3);

INSERT INTO producto (nombre) VALUES ('Televisor');
INSERT INTO producto (nombre) VALUES ('Tablet');
INSERT INTO producto (nombre) VALUES ('Libro de Historia');
INSERT INTO producto (nombre) VALUES ('Novela');
INSERT INTO producto (nombre) VALUES ('Queso Artesanal');
INSERT INTO producto (nombre) VALUES ('Aceite de Oliva');

INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (1, 1, 15);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (1, 2, 25);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (2, 1, 10);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (2, 2, 20);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (3, 3, 40);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (3, 4, 30);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (4, 3, 35);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (4, 4, 25);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (5, 5, 20);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (5, 6, 15);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (6, 5, 18);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (6, 6, 12);