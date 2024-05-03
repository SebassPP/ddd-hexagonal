package com.hexagonal.supermarket.infraestructure.out.persistence.orm;

import com.hexagonal.supermarket.domain.entity.Producto;
import com.hexagonal.supermarket.domain.enums.EstadoVenta;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "t_venta")
public class VentaORM {
    @Id
    @Column(name = "id_venta")
    private Integer id;
    @Column(name = "id_cliente")
    private String idCliente;
    @Column(name = "fecha_venta")
    private Date fechaVenta;
    @ManyToOne
    private ProductoORM producto;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "estado_venta")
    private EstadoVenta estadoVenta;
    @Column(name = "total")
    private double total;

}
