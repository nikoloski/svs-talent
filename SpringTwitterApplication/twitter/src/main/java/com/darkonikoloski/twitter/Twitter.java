package com.darkonikoloski.twitter;

import com.darkonikoloski.input.Input;
import com.darkonikoloski.message.Message;
import com.darkonikoloski.message.twittertextmessage.TwitterTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Twitter {

    private Input input;
    private List<Message> messages = new ArrayList<Message>();
    private boolean flag = true;

    @Autowired
    public Twitter (Input input) {
        this.input = input;
    }

    public void initTwitterApplication() {
        while (flag) {
            System.out.println("Choose your action: ");
            String functionality = input.getText();
            switch (functionality) {
                case "tweet":
                    System.out.println("Your message: ");
                    messages.add(new TwitterTextMessage(input.getText(), new Date()));
                    sort(messages);
                    break;
                case "list":
                    int index = 1;
                    for (Message message : messages) {
                        System.out.println(index++ + ". " + message.getMessage() + "\n" + message.getDate());
                    }
                    break;
                case "exit":
                    flag = false;
                    System.out.println("Exiting the application..");
                    break;
                default:
                    System.out.println("Indalid command, try again!");
                    break;
            }
        }
    }


    public void sort(List<Message> messages) {
        Collections.sort(messages, new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return (o1.getDate().compareTo(o2.getDate()) * (-1));
            }
        });
    }
}
