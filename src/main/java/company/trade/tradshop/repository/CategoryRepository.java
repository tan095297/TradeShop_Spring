package company.trade.tradshop.repository;

// import company.trade.tradshop.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import company.trade.tradshop.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String>{
    
}
