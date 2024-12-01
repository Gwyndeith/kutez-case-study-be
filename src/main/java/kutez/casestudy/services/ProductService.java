package kutez.casestudy.services;

import kutez.casestudy.models.Product;
import kutez.casestudy.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(@PathVariable String productID) {
        return productRepository.findById(productID).get();
    }

//    public List<Product> getProductByPopularity(@PathVariable double popularity) {
//        return productRepository.findBy()
//    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        Product existingProduct = productRepository.findById(product.getId()).get();
        existingProduct.setName(product.getName());
        existingProduct.setWeight(product.getWeight());
        existingProduct.setImages(product.getImages());
        existingProduct.setPopularityScore(product.getPopularityScore());
        return productRepository.save(existingProduct);
    }

    @DeleteMapping("${productID}")
    public void deleteProductById(@PathVariable String productID) {
        productRepository.deleteById(productID);
    }
}
