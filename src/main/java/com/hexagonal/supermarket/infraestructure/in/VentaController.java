package com.hexagonal.supermarket.infraestructure.in;

import com.hexagonal.supermarket.application.portin.IRealizarVenta;
import com.hexagonal.supermarket.application.usecase.VentaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VentaController {

    private final IRealizarVenta venta;
    @PostMapping("/venta")
    public void realizarVenta(@RequestBody VentaDTO ventaDTO) {
        venta.realizarVenta(ventaDTO);
    }
}
