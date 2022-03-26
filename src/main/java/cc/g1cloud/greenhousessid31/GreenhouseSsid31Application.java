package cc.g1cloud.greenhousessid31;

import cc.g1cloud.greenhousessid31.config.DynamoDBProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class GreenhouseSsid31Application {

    public static void main(String[] args) {
        SpringApplication.run(GreenhouseSsid31Application.class, args);
    }

}
