package com.hexagonal.supermarket.application.portin;

import com.hexagonal.supermarket.application.usecase.VentaDTO;

public interface IRealizarVenta {
    void realizarVenta(VentaDTO ventaDTO);
}
