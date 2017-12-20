package com.nikoloski.controller;

import org.springframework.stereotype.Component;

@Component
public class SignedInUserController {

    private static String signedInUserEmail = null;

    public String getSignedInUserEmail() {
        return signedInUserEmail;
    }

    public void setSignedInUserEmail(String signedInUserEmail) {
        SignedInUserController.signedInUserEmail = signedInUserEmail;
    }
}
