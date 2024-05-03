package com.hexagonal.supermarket.domain.repository;

public interface VentaPort {
    void registrarVenta(Integer idProducto, Integer cantidad);
}
