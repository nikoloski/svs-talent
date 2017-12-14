package com.darkonikoloski.input.consoleinput;

import com.darkonikoloski.input.Input;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleInput implements Input{

    private String text;

    @Override
    public String getText() {
        Scanner input = new Scanner(System.in);
        text = input.nextLine();
        return text;
    }
}
