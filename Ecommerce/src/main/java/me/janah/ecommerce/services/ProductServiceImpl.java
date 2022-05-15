package me.janah.ecommerce.services;

import lombok.AllArgsConstructor;
import me.janah.ecommerce.dtos.ProductDTO;
import me.janah.ecommerce.entities.Product;
import me.janah.ecommerce.mappers.CatalogMappers;
import me.janah.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CatalogMappers catalogMappers;

    public ProductDTO save(ProductDTO productDTO) {
        Product product = catalogMappers.fromProductDTO(productDTO);
        if (product.getId() == null) {
            product.setId(UUID.randomUUID().toString());
        }
        Product savedProduct = productRepository.save(product);
        return catalogMappers.fromProduct(savedProduct);
    }

    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(catalogMappers::fromProduct).collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(String id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return null;
        }
        return catalogMappers.fromProduct(product);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
