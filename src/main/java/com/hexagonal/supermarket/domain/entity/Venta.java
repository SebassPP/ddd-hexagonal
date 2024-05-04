package com.hexagonal.supermarket.domain.entity;

import com.hexagonal.supermarket.domain.enums.EstadoVenta;

import java.util.Date;

public class Venta {
    private Integer id;
    private String idCliente;
    private Date fechaVenta;
    private Producto producto;
    private int cantidad;
    private EstadoVenta estadoVenta;
}
