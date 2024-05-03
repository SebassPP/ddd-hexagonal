package com.hexagonal.supermarket.application.exception;

public class LimiteProductosVenta extends RuntimeException{
    public LimiteProductosVenta(Integer cantidad) {
        super("No se pueden vender " + cantidad + " productos");
    }
}
