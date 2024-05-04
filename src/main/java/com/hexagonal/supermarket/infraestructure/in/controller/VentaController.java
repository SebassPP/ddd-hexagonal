package com.hexagonal.supermarket.infraestructure.in.controller;

import com.hexagonal.supermarket.application.portin.IRealizarVenta;
import com.hexagonal.supermarket.application.usecase.VentaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Venta", description = "Endpoint para realizar una venta")
public class VentaController {

    private final IRealizarVenta venta;
    @Operation(
            summary = "Realizar una venta",
            description = "Realiza una venta de productos"
    )
    @PostMapping("/venta")
    public void realizarVenta(@RequestBody VentaDTO ventaDTO) {
        venta.realizarVenta(ventaDTO);
    }
}
