package com.hexagonal.supermarket.infraestructure.in.controller;

import com.hexagonal.supermarket.domain.entity.Producto;
import com.hexagonal.supermarket.infraestructure.out.persistence.adapter.ProductoAdapterRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Tag(name = "Productos", description = "Endpoint de gestion de productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoAdapterRepository productoService;

    @Operation(
            summary = "Obtener todos los productos",
            description = "Retorna una lista con todos los productos"
    )
    @GetMapping("/list")
    public ResponseEntity listProducts() {
        return new ResponseEntity(productoService.obtenerTodosLosProductos(), HttpStatus.OK);
    }
    @Operation(
            summary = "Agregar un producto",
            description = "Agrega un producto a la base de datos"
    )
    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody Producto producto) {
        return new ResponseEntity(productoService.agregarProducto(producto), HttpStatus.CREATED);
    }
    @Operation(
            summary = "Actualizar un producto",
            description = "Actualiza un producto en la base de datos"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Producto producto) {
        return new ResponseEntity(productoService.editarProducto(id, producto), HttpStatus.OK);
    }
    @Operation(
            summary = "Eliminar un producto",
            description = "Elimina un producto de la base de datos"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @Operation(
            summary = "Obtener un producto",
            description = "Retorna un producto por su id"
    )
    @GetMapping("/{id}")
    public ResponseEntity getProducto(@PathVariable Integer id) {
        return new ResponseEntity(productoService.obtenerProductoPorId(id), HttpStatus.OK);
    }
}
