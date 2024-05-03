package com.hexagonal.supermarket.domain.exception;

public class StockInsuficienteException  extends RuntimeException{
    public StockInsuficienteException(Integer idProducto) {
        super("No hay stock suficiente para el producto con id " + idProducto);
    }
}
