package me.janah.ecommerce.web;

import lombok.AllArgsConstructor;
import me.janah.ecommerce.dtos.ProductDTO;
import me.janah.ecommerce.entities.Product;
import me.janah.ecommerce.repositories.ProductRepository;
import me.janah.ecommerce.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ProductRestController {

    // we don't use repository directly, but we use the service to do the work
    //private ProductRepository productRepository;
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> ProductList() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@PathVariable(name = "id") String id) {
        return productService.findById(id);
    }

    @PostMapping("/products")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @PutMapping("/products/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO, @PathVariable(name = "id") String id) {
        productDTO.setId(id);
        return productService.save(productDTO);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable(name = "id") String id) {
        productService.delete(id);
    }

}
