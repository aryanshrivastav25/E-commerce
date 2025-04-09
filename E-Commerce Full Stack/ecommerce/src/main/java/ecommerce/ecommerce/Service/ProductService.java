package ecommerce.ecommerce.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ecommerce.ecommerce.Model.Product;
import ecommerce.ecommerce.Repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts()
    {
        return repo.findAll();
    }

    public Product getProduct(int id)
    {
        return repo.findById(id).orElse(new Product(-1));
    }

    public void addProduct(Product product, MultipartFile image) throws IOException {
        // First set the image attributes in Product object
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());

        product.setImageData(image.getBytes());

        repo.save(product);
    }

    public byte[] getProductImage(int id) {
        return repo.findById(id).orElse(new Product(-1)).getImageData();
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        Product prod = repo.findById(id).orElse(new Product(-1));
        prod = product;
        prod.setImageName(imageFile.getOriginalFilename());
        prod.setImageType(imageFile.getContentType());
        prod.setImageData(imageFile.getBytes());
        repo.save(prod);
        return prod;
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchByKeyword(String keyword) {
        return repo.searchByKeyWord(keyword);
    }
}
