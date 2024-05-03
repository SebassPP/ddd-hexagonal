package com.hexagonal.supermarket.application.exception;

public class ProductoNoExisteException extends RuntimeException{
    public ProductoNoExisteException(Integer idProducto) {
        super("El producto con id " + idProducto + " no existe");
    }
}
