package com.hexagonal.supermarket.infraestructure.out.persistence.adapter;

import com.hexagonal.supermarket.domain.repository.VentaPort;
import com.hexagonal.supermarket.infraestructure.out.persistence.adapter.repository.VentaJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VentaAdapterRepository implements VentaPort {
    private final VentaJPARepository ventaJPARepository;
    @Override
    public void registrarVenta(Integer idProducto, Integer cantidad) {
        //TODO: Implementar la lógica de registrar la venta
    }
}
