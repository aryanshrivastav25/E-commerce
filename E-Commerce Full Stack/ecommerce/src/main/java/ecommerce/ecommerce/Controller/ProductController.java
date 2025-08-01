package ecommerce.ecommerce.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ecommerce.ecommerce.Model.Product;
import ecommerce.ecommerce.Service.ProductService;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api")
public class ProductController 
{
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() // ResponseEntity allows us to send status code(200, 401, 404...) along with the data
    {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.ACCEPTED);
    }


    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable int id)
    {
        return new ResponseEntity<>(service.getProductImage(id), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id)
    {
        Product product = service.getProduct(id);
        if (product.getId() != -1)
            return new ResponseEntity<>(product, HttpStatus.OK);
        return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
    } 
    // If we return FOUND status instead of OK, then the browser does not work on that request as FOUND request generally looks for a header url to go to, but here we are only finding the product by id so it we need to send OK, not FOUND

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile)
    // name imageFile should be same as specified in the addProduct component in frontend
    // Since, the object contains image also, so the server accept the data into 2 parts, the first part is json format and second part is image stored in MultipartFile object
    {
        try 
        {
            service.addProduct(product, imageFile);
            return new ResponseEntity<>(HttpStatus.OK);
        }
         catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }  
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile)
    {
        try {
            Product prod = service.updateProduct(id, product, imageFile);
            if (prod.getId() != -1) return new ResponseEntity<>("Success", HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
        catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id)
    {
        service.deleteProduct(id);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchByKeyword(@RequestParam String keyword)
    {
        List<Product> products = service.searchByKeyword(keyword);
        System.out.println("Searching with: " + keyword);
        if (products.isEmpty())
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
