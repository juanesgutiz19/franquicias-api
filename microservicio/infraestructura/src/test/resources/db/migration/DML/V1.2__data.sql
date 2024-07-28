INSERT INTO franquicia (nombre) VALUES ('Tecnología Global');
INSERT INTO franquicia (nombre) VALUES ('Papelería Universal');
INSERT INTO franquicia (nombre) VALUES ('Gourmet Exquisito');

INSERT INTO sucursal (nombre, franquicia_id) VALUES ('Tecnología Global - Centro', 1);
INSERT INTO sucursal (nombre, franquicia_id) VALUES ('Tecnología Global - Norte', 1);
INSERT INTO sucursal (nombre, franquicia_id) VALUES ('Papelería Universal - Centro', 2);
INSERT INTO sucursal (nombre, franquicia_id) VALUES ('Papelería Universal - Sur', 2);
INSERT INTO sucursal (nombre, franquicia_id) VALUES ('Gourmet Exquisito - Este', 3);
INSERT INTO sucursal (nombre, franquicia_id) VALUES ('Gourmet Exquisito - Oeste', 3);

INSERT INTO producto (nombre) VALUES ('Smartphone');
INSERT INTO producto (nombre) VALUES ('Laptop');
INSERT INTO producto (nombre) VALUES ('Cuaderno');
INSERT INTO producto (nombre) VALUES ('Lápiz');
INSERT INTO producto (nombre) VALUES ('Chocolate Artesanal');
INSERT INTO producto (nombre) VALUES ('Mermelada');

INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (1, 1, 20);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (1, 2, 30);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (2, 1, 15);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (2, 2, 25);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (3, 3, 50);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (3, 4, 40);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (4, 3, 45);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (4, 4, 35);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (5, 5, 25);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (5, 6, 20);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (6, 5, 22);
INSERT INTO inventario_sucursal (sucursal_id, producto_id, cantidad_stock) VALUES (6, 6, 18);
