package demo.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import java.time.Duration;

@EnableAsync
@Configuration
public class Config {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        builder.setConnectTimeout(Duration.ofSeconds(5));
        builder.setReadTimeout(Duration.ofSeconds(20));
        return builder.build();
    }
}
