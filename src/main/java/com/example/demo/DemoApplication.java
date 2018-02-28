package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@RestController
@EnableWebMvc // comment / uncomment to see test failing
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    Pojo testPojoSerialization() {
        return new Pojo("some value", null);
    }

    private static class Pojo {
        private final String populated;
        private final String nullable;

        private Pojo(String populated, String nullable) {
            this.populated = populated;
            this.nullable = nullable;
        }

        public String getPopulated() {
            return populated;
        }

        public String getNullable() {
            return nullable;
        }

    }
}
