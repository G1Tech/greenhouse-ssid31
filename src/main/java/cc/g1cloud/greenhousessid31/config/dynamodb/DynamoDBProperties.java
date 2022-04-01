package cc.g1cloud.greenhousessid31.config.dynamodb;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "dynamodb")
@Data
@Validated
public class DynamoDBProperties {
    @NotNull
    private String serviceEndpoint;
    @NotNull
    private String signingRegion;
    @NotNull
    private String accessKey;
    @NotNull
    private String secretKey;

}
