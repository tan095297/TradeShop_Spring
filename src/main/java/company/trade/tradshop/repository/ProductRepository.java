package company.trade.tradshop.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import company.trade.tradshop.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

    public List<Product> findByNameContaining(String name);


    
}
