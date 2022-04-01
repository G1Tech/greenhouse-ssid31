package cc.g1cloud.greenhousessid31.config.web;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "web.cors")
@ConditionalOnProperty(prefix = "web.cors", name = "enabled", havingValue = "true")
@Data
public class WebProperties {

    private List<String> allowedOrigins;

}
