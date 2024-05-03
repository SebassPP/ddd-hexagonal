package com.hexagonal.supermarket.infraestructure.out.persistence.adapter;

import com.hexagonal.supermarket.domain.entity.Producto;
import com.hexagonal.supermarket.domain.repository.ProductoPort;
import com.hexagonal.supermarket.infraestructure.out.persistence.adapter.repository.ProductoJPARepository;
import com.hexagonal.supermarket.infraestructure.out.persistence.orm.ProductoORM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoAdapterRepository implements ProductoPort{
    private final ProductoJPARepository productoJPARepository;

    @Override
    public void actualizarStockProducto(Integer idProducto, Integer cantidad) {
        ProductoORM productoORM = productoJPARepository.findById(idProducto).get();
        productoORM.setStock(productoORM.getStock() - cantidad);
        productoJPARepository.save(productoORM);
    }

    @Override
    public Producto obtenerProductoPorId(Integer idProducto) {
        Optional<ProductoORM> producto = productoJPARepository.findById(idProducto);
        producto.ifPresent(ProductoORM::convertToProducto);
        return null;
    }

}
