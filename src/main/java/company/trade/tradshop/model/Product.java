package company.trade.tradshop.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("products")
@Getter @Setter @NoArgsConstructor
public class Product {
    
    @Id
    private String _id;
    private String name;

    private String details;
    private String img;


 
    // แก้ได้โดยการตัวสินค้าที่จะร้องขอการเทรด จะต้องไม่มีการเก็บข้อมูลด้านล่าง หรือเก็บได้ แต่เลือกเก็บแค่ itemToTrade.id .name .details 
    
    //ถ้าเก็บคนเดียวไม่ต้องใช้ Array 
    private Member  posters  = new Member();

    private Category category = new Category();

    private List<TraderRequest> traderRequests = new ArrayList<TraderRequest>();
    

}
