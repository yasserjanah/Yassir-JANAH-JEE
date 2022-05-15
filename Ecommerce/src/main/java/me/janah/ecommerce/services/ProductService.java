package me.janah.ecommerce.services;

import me.janah.ecommerce.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO save(ProductDTO productDTO);
    List<ProductDTO> findAll();
    ProductDTO findById(String id);
    void delete(String id);
}
