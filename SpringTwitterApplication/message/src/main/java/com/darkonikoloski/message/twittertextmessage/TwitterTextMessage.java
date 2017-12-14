package com.darkonikoloski.message.twittertextmessage;

import com.darkonikoloski.message.Message;

import java.util.Date;

public class TwitterTextMessage implements Message {

    private String text;
    private Date dateCreated;

    public TwitterTextMessage (String text, Date dateCreated) {
        this.text = text;
        this.dateCreated = dateCreated;
    }

    @Override
    public Date getDate() {
        return dateCreated;
    }

    @Override
    public String getMessage() {
        return text;
    }
}
