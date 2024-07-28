UPDATE inventario_sucursal
SET cantidad_stock = :cantidad_stock
WHERE sucursal_id = :sucursal_id
AND producto_id = :producto_id;