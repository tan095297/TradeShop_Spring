package company.trade.tradshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import company.trade.tradshop.model.Member;
import company.trade.tradshop.model.Poster;
import company.trade.tradshop.model.Product;
import company.trade.tradshop.repository.ProductRepository;

@Service
public class ProductService {

    
    @Autowired
    private ProductRepository productRepository;
    


    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }


    public List<Product> findProductByName(String name){
        return productRepository.findByNameContaining(name);
    }

    public Optional<Product> findProductById(String id){
        return productRepository.findById(id);
    }

    public Optional<Product> updateProduct(String id, Product product){
        // import old product from ID prodcut
        Product currentProduct = productRepository.findById(id).get();
        currentProduct.setName(product.getName());
        currentProduct.setDetails(product.getDetails());
        currentProduct.setImg(product.getImg());
        
        return Optional.of(productRepository.save(currentProduct));
    }

    // public Optional<Product> addPosters(String id, Poster poster){
    //     Product currentProduct = productRepository.findById(id).get();
    //    List<Poster> posters = currentProduct.getPosters();
    //     currentProduct.setPosters((Member) posters);
    //     return Optional.of(productRepository.save(currentProduct));
    // }

    public boolean deleteProduct(String id){
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

	
}
