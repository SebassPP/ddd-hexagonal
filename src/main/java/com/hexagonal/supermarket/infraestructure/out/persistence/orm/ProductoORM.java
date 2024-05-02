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
    private String id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "proveedor")
    private String proveedor;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "stock")
    private int stock;
    @Column(name = "precio")
    private double precio;
    @Column(name = "fecha_agregado")
    private Date fechaAgregado;
    @Column(name = "estado_producto")
    private EstadoProducto estadoProducto;

    public Producto convertToProducto() {
        return new Producto(id, nombre, descripcion, stock, precio);
    }
}
