SELECT sucursal_id, sucursal_nombre, producto_id, producto_nombre, cantidad_stock
FROM (
    SELECT
        s.id AS sucursal_id,
        s.nombre AS sucursal_nombre,
        p.id AS producto_id,
        p.nombre AS producto_nombre,
        i.cantidad_stock,
        ROW_NUMBER() OVER (PARTITION BY s.id ORDER BY i.cantidad_stock DESC, p.id) AS rn
    FROM sucursal s
    JOIN inventario_sucursal i ON s.id = i.sucursal_id
    JOIN producto p ON i.producto_id = p.id
    WHERE s.franquicia_id = :franquicia_id
) subquery
WHERE rn = 1
ORDER BY sucursal_nombre;