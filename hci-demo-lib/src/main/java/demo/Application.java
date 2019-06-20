package demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.dto.Result;
import demo.service.ITypicodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Profile("cli")
@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner run(ITypicodeService typicodeService, ObjectMapper objectMapper) {
        return args -> {
            if(args.length == 0) {
                log.error("Please provide userId");
                return;
            }
            Result result = typicodeService.getResult(args[0]);
            log.info(objectMapper.writeValueAsString(result));
        };
    }

}
