package com.hexagonal.supermarket.infraestructure.out.persistence.adapter.repository;
import com.hexagonal.supermarket.infraestructure.out.persistence.orm.ProductoORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoJPARepository extends JpaRepository <ProductoORM, Integer> {
}
