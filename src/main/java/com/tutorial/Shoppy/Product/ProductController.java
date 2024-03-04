package com.tutorial.Shoppy.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
//        this.productService = new ProductService(); //We should avoid this, instead use Dependancy Injection
        this.productService = productService;
    }

    @GetMapping
    public List<product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping(path = "{productId}")
    public product getProductById(@PathVariable("productId") Long productId){
        return productService.getProductById(productId);
    }

    @PostMapping
    public void registerNewProduct(@RequestBody product product){
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
    }

    @PutMapping(path = "{productId}")
    public void updateProduct(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String description
    ) {
        productService.updateProduct(productId, name, email, description);
    }
}
