package company.trade.tradshop.model;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter @NoArgsConstructor
public class TraderRequest {

        private Member requester = new Member();


//ดู Product นี้นะ ว่าเก็บอะไรบ้าง
        private Product itemToTrade = new Product();

        @CreatedDate
        private Date requestDated;
   
    
}
