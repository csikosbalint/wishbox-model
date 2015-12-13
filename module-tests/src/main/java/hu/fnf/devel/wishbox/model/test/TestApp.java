package hu.fnf.devel.wishbox.model.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
        {
                "hu.fnf.devel.wishbox.model.repository.mongo",
                "hu.fnf.devel.wishbox.model.entity.mongo",
                "hu.fnf.devel.wishbox.model.test"
        }
)
public class TestApp {
    public static final String ROOT = "/";

    public static void main(String[] args) {
        SpringApplication.run(TestApp.class, args);
    }
}
