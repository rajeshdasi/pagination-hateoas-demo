package com.example.paginationdemo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@SpringBootApplication
@EnableSpringDataWebSupport
public class PaginationDemoApplication {

    @Bean
    ApplicationRunner runner(ProductRepository repository){
        return args -> {
              repository.save(new Product("iPhone",1499, LocalDateTime.now()));
              repository.save(new Product("Mac Book Pro",3499, LocalDateTime.now()));
              repository.save(new Product("iPad",799, LocalDateTime.now()));
              repository.save(new Product("AirTags",149.90, LocalDateTime.now()));
              repository.save(new Product("Mac Book Air",999.79, LocalDateTime.now()));
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(PaginationDemoApplication.class, args);
    }

}

