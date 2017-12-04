import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class WordCounter {

    public static void main(String[] args) {

        Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
        String line;
        String[] words;
        int counter;

        if (args.length == 1) {
            try {
                FileReader file = new FileReader(args[0]);
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
                file.close();
            } catch (IOException e) {
                System.out.println("Error - " + e.toString());
            }

            for (Object key : hash.keySet()) {
                System.out.println(key + ": " + hash.get(key));
            }
        } else {
            System.out.println("Wrong number of arguments!");
        }

    }
}