package com.tutorial.Shoppy.Product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<product> getProducts(){
        return productRepository.findAll();
    }

    public void addNewProduct(product product) {
        Optional<product> studentOptional = productRepository.findProductsByEmail(product.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
            //Throws exception if email is taken
        }
        productRepository.save(product);

        System.out.println(product);
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            throw new IllegalStateException("product with id " + productId + " does not exist");
        }
        productRepository.deleteById(productId);
    }

    @Transactional //We dont have JPQl queries
    public void updateProduct(Long productId, String email, String name, String description) {
        //Getting ID from the database, if not exists throw exception

        //Getting student object from the database by ID
        product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException(
                        "product with id " + productId + " does not exist"
                ));

        if(name != null && name.length() > 0 && !name.equals(product.getName())){
            product.setName(name);
            System.out.println(name);

        }

        if(email != null && email.length() > 0 && !email.equals(product.getEmail())){
            Optional<product> productOptional = productRepository.findProductsByEmail(email);
            if(productOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            product.setEmail(email);
        }

        if (description != null && description.length() > 0 && !description.equals(product.getDescription())) {
            product.setDescription(description);
        }
    }

    public product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("product with id " + productId + " does not exist"));
    }

}
