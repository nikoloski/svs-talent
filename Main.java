package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Hashtable<String, Integer> hash = new Hashtable();
        String line;
        String[] words;
        int counter;
        FileReader file = null;
        
        try {
            file = new FileReader("myFile.txt");
            BufferedReader buff = new BufferedReader(file);
            boolean eof = false;
            while (!eof) {
                line = buff.readLine();
                if (line == null) {
                    eof = true;
                } else {
                    words = line.split(" ");
                    for (String word : words) {
                        if (hash.containsKey(word)) {
                            counter = hash.get(word);
                            counter++;
                            hash.put(word, counter);
                        } else {
                            hash.put(word, 1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error - " + e.toString());
        } finally {
            file.close();
        }

        for (Object key : hash.keySet() ) {
            System.out.println(key + " " + hash.get(key));
        }
    }
}
