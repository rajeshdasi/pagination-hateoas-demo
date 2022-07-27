package com.example.paginationdemo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductRouter {

    final ProductRepository productRepository;

    final ProductModelAssembler productModelAssembler;

    final PagedResourcesAssembler pagedResourcesAssembler;

    public ProductRouter(ProductRepository productRepository, ProductModelAssembler productModelAssembler, PagedResourcesAssembler pagedResourcesAssembler) {
        this.productRepository = productRepository;
        this.productModelAssembler = productModelAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @GetMapping
    public ResponseEntity get() {
        Page<Product> products = productRepository.findAll(PageRequest.of(0,2));
        return ResponseEntity
                        .ok()
                        .contentType(MediaTypes.HAL_JSON)
                        .body(pagedResourcesAssembler.toModel(products,productModelAssembler));
    }
}
