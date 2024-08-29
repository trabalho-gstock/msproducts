package com.gstock.msproducts.application;

import com.gstock.msproducts.application.exception.DuplicateSkuException;
import com.gstock.msproducts.domain.Product;
import com.gstock.msproducts.infra.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductRepository repository;

    public Product create(Product product){
        if(repository.getBySku(product.getSku()).isPresent()){
            throw new DuplicateSkuException(product.getSku());
        }
        return repository.save(product);
    }

    public Optional<Product> getProductBySku(String sku){
        return repository.getBySku(sku);
    }

    public List<Product> getAllProducts(){
        return repository.findAll();
    }
}
