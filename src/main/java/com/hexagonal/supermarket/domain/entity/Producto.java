package com.hexagonal.supermarket.domain.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Producto {

        private String id;
        private String nombre;
        private String descripcion;
        private int stock;
        private double precio;

}
