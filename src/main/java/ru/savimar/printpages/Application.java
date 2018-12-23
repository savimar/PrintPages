package ru.savimar.printpages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("ru.savimar.printpages.*")
@EnableJpaRepositories("ru.savimar.printpages.Repository")
@EntityScan("ru.savimar.printpages.Model")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}