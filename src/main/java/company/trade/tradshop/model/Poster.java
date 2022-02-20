package company.trade.tradshop.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("poster")
@Getter @Setter @NoArgsConstructor
public class Poster {
    
    private String name ;
    private String email ;
    private String tel ;
    
}
