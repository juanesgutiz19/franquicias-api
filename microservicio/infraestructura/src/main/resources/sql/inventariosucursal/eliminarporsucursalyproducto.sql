DELETE FROM inventario_sucursal
WHERE sucursal_id = :sucursal_id
AND producto_id = :producto_id;