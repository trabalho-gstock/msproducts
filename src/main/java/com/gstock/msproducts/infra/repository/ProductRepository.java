package com.gstock.msproducts.infra.repository;

import com.gstock.msproducts.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> getBySku(String sku);
}
