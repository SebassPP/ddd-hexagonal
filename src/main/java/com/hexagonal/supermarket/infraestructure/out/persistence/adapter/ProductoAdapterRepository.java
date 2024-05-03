package com.hexagonal.supermarket.infraestructure.out.persistence.adapter;

import com.hexagonal.supermarket.application.exception.ProductoNoExisteException;
import com.hexagonal.supermarket.domain.entity.Producto;
import com.hexagonal.supermarket.domain.repository.ProductoPort;
import com.hexagonal.supermarket.infraestructure.out.persistence.adapter.repository.ProductoJPARepository;
import com.hexagonal.supermarket.infraestructure.out.persistence.orm.ProductoORM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoAdapterRepository implements ProductoPort{
    private final ProductoJPARepository productoJPARepository;

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoJPARepository.findAll().stream()
                .map(ProductoORM::convertToProducto)
                .collect(Collectors.toList());
    }

    @Override
    public Producto agregarProducto(Producto producto) {
        ProductoORM productoORM = new ProductoORM();
        productoORM.setId(producto.getId());
        productoORM.setNombre(producto.getNombre());
        productoORM.setDescripcion(producto.getDescripcion());
        productoORM.setStock(producto.getStock());
        productoORM.setPrecio(producto.getPrecio());
        productoORM.setFechaAgregado(new Date());
        productoJPARepository.save(productoORM);
        return productoORM.convertToProducto();
    }

    @Override
    public Producto editarProducto(Integer idProducto, Producto producto) {
        Optional<ProductoORM> productoOptional = productoJPARepository.findById(idProducto);
        if (productoOptional.isPresent()) {
            ProductoORM productoORM = productoOptional.get();
            productoORM.setNombre(producto.getNombre());
            productoORM.setDescripcion(producto.getDescripcion());
            productoORM.setStock(producto.getStock());
            productoORM.setPrecio(producto.getPrecio());
            productoJPARepository.save(productoORM);
            return productoORM.convertToProducto();
        }else {
            throw new ProductoNoExisteException(idProducto);
        }
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        productoJPARepository.deleteById(idProducto);
    }

    @Override
    public void RestarStockProducto(Integer idProducto, Integer cantidad) {
        ProductoORM productoORM = productoJPARepository.findById(idProducto).get();
        productoORM.setStock(productoORM.getStock() - cantidad);
        productoJPARepository.save(productoORM);
    }

    @Override
    public Producto obtenerProductoPorId(Integer idProducto) {
        Optional<ProductoORM> producto = productoJPARepository.findById(idProducto);
        return producto.map(ProductoORM::convertToProducto).orElse(null);
    }

}
