package kutez.casestudy.controllers;

import kutez.casestudy.models.Product;
import kutez.casestudy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin
    @PostMapping("/createNewProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @CrossOrigin
    @GetMapping("/getAllProducts")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @CrossOrigin
    @GetMapping("/getProductById/{productID}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable String productID) {
        return productService.getProductById(productID);
    }

    @CrossOrigin
    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @CrossOrigin
    @DeleteMapping("/deleteProduct/{productID}")
    public void deleteProductById(@PathVariable String productID) {
        productService.deleteProductById(productID);
    }
}
