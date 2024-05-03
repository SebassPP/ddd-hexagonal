package com.hexagonal.supermarket.infraestructure.out.persistence.adapter.repository;
import com.hexagonal.supermarket.infraestructure.out.persistence.orm.VentaORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaJPARepository extends JpaRepository <VentaORM, Integer> {
}
