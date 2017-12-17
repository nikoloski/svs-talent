package com.seavus;

import com.seavus.library.Library;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LibraryApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(LibraryApplication.class, args);
        ctx.getBean(Library.class).init();

        ((ConfigurableApplicationContext) ctx).close();
        System.exit(0);
    }
}
