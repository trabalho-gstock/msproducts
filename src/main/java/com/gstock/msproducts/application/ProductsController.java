package com.gstock.msproducts.application;

import com.gstock.msproducts.application.exception.DuplicateSkuException;
import com.gstock.msproducts.application.representation.ProductSaveRequest;
import com.gstock.msproducts.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService service;

    @PostMapping
    public ResponseEntity register(@RequestBody ProductSaveRequest request){
        Product product = request.toModel();
        service.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "sku")
    public ResponseEntity getProductsBySku(@RequestParam("sku") String sku){
        Optional<Product> product = service.getProductBySku(sku);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity getAll(){
        List<Product> productList = service.getAllProducts();
        return ResponseEntity.ok(productList);
    }
}
