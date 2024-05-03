package com.hexagonal.supermarket.domain.repository;

import com.hexagonal.supermarket.domain.entity.Producto;

public interface ProductoPort {
    void actualizarStockProducto(Integer idProducto, Integer cantidad);
    Producto obtenerProductoPorId(Integer idProducto);
}
