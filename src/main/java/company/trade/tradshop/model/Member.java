package company.trade.tradshop.model;

// import java.util.ArrayList;
import java.util.Date;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("members")
@Getter @Setter @NoArgsConstructor
public class Member {

    @Id
    private String _id;

    private String name;

    private String tel;
    private String sex;

    private String birthday;
    private String address;
    private String email;
    private String lineId;
    private String password;


    @CreatedDate
    private Date createdAt;


    


    
}
