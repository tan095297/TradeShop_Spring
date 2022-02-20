package company.trade.tradshop.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import company.trade.tradshop.model.Member;

public interface MemberRepository extends MongoRepository<Member, String>  {

   
    public List<Member> findByNameContaining(String name);
    
}
