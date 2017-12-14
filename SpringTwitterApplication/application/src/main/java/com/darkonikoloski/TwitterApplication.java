package com.darkonikoloski;

import com.darkonikoloski.twitter.Twitter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TwitterApplication {

    public static void displayMenu() {
        System.out.println("Welcome to Darko Nikoloski's Twitter Application!");
        System.out.println("When asked for an action, type: \n1. tweet - to tweet a message;" +
                "\n2. list - to list all messages in a chronological order with the latest messages displayed first;" +
                "\n3. exit - to exit the application.");
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(TwitterApplication.class, args);
        ctx.getBean(TwitterApplication.class).displayMenu();
        ctx.getBean(Twitter.class).initTwitterApplication();
    }
}
