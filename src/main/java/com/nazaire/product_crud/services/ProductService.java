package com.nazaire.product_crud.services;

import com.nazaire.product_crud.models.Product;
import com.nazaire.product_crud.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepo.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepo.deleteById(id);
    }

    public Optional<Product> updateProduct(Integer id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepo.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setProductName(updatedProduct.getProductName());
            product.setProductPrice(updatedProduct.getProductPrice());
            product.setProductDescription(updatedProduct.getProductDescription());
            return Optional.of(productRepo.save(product));
        }
        return Optional.empty();
    }
}
