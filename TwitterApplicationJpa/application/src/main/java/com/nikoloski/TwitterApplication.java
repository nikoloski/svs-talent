package com.nikoloski;

import com.nikoloski.twitter.Twitter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TwitterApplication {

    public static void displayMenu() {
        System.out.println("Welcome to Darko Nikoloski's Twitter Application!");
        System.out.println("When asked for an action, type: \n1. signup - to sign up with your email address, with instant sign in;" +
                "\n2. signin - to sign in using your email address;" +
                "\n3. signout - to sign out;" +
                "\n4. follow - to follow a user with a certain email address;" +
                "\n5. tweet - to tweet a message, but you must be signed in;" +
                "\n6. list tweets - to list all messages in a chronological order with the latest messages displayed first;" +
                "\n7. exit - to exit the application.");
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(TwitterApplication.class, args);
        ctx.getBean(TwitterApplication.class).displayMenu();
        ctx.getBean(Twitter.class).initTwitterApplication();

        ((ConfigurableApplicationContext) ctx).close();
        System.exit(0);
    }
}
