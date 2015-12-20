package hu.fnf.devel.wishbox.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
        {
                "hu.fnf.devel.wishbox.model.repository.mongo",
                "hu.fnf.devel.wishbox.model.test.service"
        }
)
public class ModelApplication {
    public static final String ROOT = "/";

    public static void main(String[] args) {
        SpringApplication.run(ModelApplication.class, args);
    }

}
