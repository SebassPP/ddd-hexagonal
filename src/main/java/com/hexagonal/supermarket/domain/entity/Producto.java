package com.hexagonal.supermarket.domain.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Producto {

        private Integer id;
        private String nombre;
        private String descripcion;
        private Integer stock;
        private double precio;

}
