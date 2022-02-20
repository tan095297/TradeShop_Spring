package company.trade.tradshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class TradshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradshopApplication.class, args);
	}

}
