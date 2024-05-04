package com.hexagonal.supermarket.domain.exception;

public class ProductoNoExisteException extends RuntimeException{
    public ProductoNoExisteException(Integer idProducto) {
        super("El producto con id " + idProducto + " no existe");
    }
}
