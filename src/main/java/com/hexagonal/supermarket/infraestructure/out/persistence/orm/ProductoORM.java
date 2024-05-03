package com.hexagonal.supermarket.infraestructure.out.persistence.orm;

import com.hexagonal.supermarket.domain.entity.Producto;
import com.hexagonal.supermarket.domain.enums.EstadoProducto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "t_producto")
public class ProductoORM {
    @Id
    @Column(name = "id_producto")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "precio")
    private double precio;
    @Column(name = "fecha_agregado")
    private Date fechaAgregado;

    public Producto convertToProducto() {
        return new Producto(id, nombre, descripcion, stock, precio);
    }
}
