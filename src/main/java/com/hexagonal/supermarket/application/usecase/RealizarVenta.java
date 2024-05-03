package com.hexagonal.supermarket.application.usecase;

import com.hexagonal.supermarket.application.exception.LimiteProductosVenta;
import com.hexagonal.supermarket.application.exception.ProductoNoExisteException;
import com.hexagonal.supermarket.application.portin.IRealizarVenta;
import com.hexagonal.supermarket.domain.enums.EstadoVenta;
import com.hexagonal.supermarket.domain.exception.StockInsuficienteException;
import com.hexagonal.supermarket.domain.repository.ProductoPort;
import com.hexagonal.supermarket.infraestructure.out.persistence.adapter.repository.ProductoJPARepository;
import com.hexagonal.supermarket.infraestructure.out.persistence.adapter.repository.VentaJPARepository;
import com.hexagonal.supermarket.infraestructure.out.persistence.orm.ProductoORM;
import com.hexagonal.supermarket.infraestructure.out.persistence.orm.VentaORM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class RealizarVenta implements IRealizarVenta {
    private final VentaJPARepository ventaJPARepository;
    private final ProductoJPARepository productoJPARepository;
    private final ProductoPort productoPort;
    private final Random random = new Random();

    @Override
    @Transactional
    public void realizarVenta(VentaDTO ventaDTO) {
        Optional<ProductoORM> productoOptional = productoJPARepository.findById(ventaDTO.idProducto());

        if (!productoOptional.isPresent()) {
            throw new ProductoNoExisteException(ventaDTO.idProducto());
        }
        if (ventaDTO.cantidad() >= 40) {
            throw new LimiteProductosVenta(ventaDTO.cantidad());
        }

        ProductoORM productoORM = productoOptional.get();
        VentaORM ventaORM = new VentaORM();
        String idClienteAleatorioString = String.valueOf(random.nextInt(10000));

        EstadoVenta estadoVenta = productoORM.getStock() < ventaDTO.cantidad() ? EstadoVenta.CANCELADA : EstadoVenta.COMPLETADA;

        if (estadoVenta == EstadoVenta.CANCELADA) {
            throw new StockInsuficienteException(ventaDTO.idProducto());
        }
        productoPort.RestarStockProducto(ventaDTO.idProducto(), ventaDTO.cantidad());
        ventaORM.setIdCliente(idClienteAleatorioString);
        ventaORM.setFechaVenta(new Date());
        ventaORM.setProducto(productoORM);
        ventaORM.setCantidad(ventaDTO.cantidad());
        ventaORM.setEstadoVenta(estadoVenta);
        ventaJPARepository.save(ventaORM);
    }
}
