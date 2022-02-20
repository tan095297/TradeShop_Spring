package company.trade.tradshop.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("categories")
@Getter @Setter @NoArgsConstructor
public class Category {

    @Id
    private String _id;

    private String Id;

    private String name ;

    @CreatedDate
    private Date createdAt;
    
}
