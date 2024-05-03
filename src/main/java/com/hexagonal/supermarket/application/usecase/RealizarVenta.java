package com.hexagonal.supermarket.application.usecase;

import com.hexagonal.supermarket.application.portin.IRealizarVenta;
import com.hexagonal.supermarket.infraestructure.out.persistence.adapter.repository.VentaJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RealizarVenta implements IRealizarVenta {
    private final VentaJPARepository ventaJPARepository;
    @Override
    public void realizarVenta(VentaDTO ventaDTO) {

    }
}
