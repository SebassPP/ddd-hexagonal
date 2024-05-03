package com.hexagonal.supermarket.domain.repository;

import com.hexagonal.supermarket.domain.entity.Producto;

import java.util.List;

public interface ProductoPort {
    List<Producto> obtenerTodosLosProductos();
    Producto agregarProducto(Producto producto);
    Producto editarProducto(Integer idProducto, Producto producto);
    void eliminarProducto(Integer idProducto);
    void RestarStockProducto(Integer idProducto, Integer cantidad);
    Producto obtenerProductoPorId(Integer idProducto);
}
