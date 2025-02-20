package wordscrambler;

import java.io.*;
import java.util.*;

public class Scramble {
    private List<String> words;
    private String currentWord;
    
    public Scramble(String fileName) throws IOException {
        words = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextLine()) {
                words.add(fileScanner.nextLine().trim());
            }
        }
        currentWord = null;
    }

    public String getRealWord() {
        if (words.isEmpty()) return null;

        if (currentWord == null || currentWord.equals("")) {
            currentWord = words.remove(0);
        } else {
            currentWord = words.remove(0);
        }

        return currentWord;
    }


    public String getScrambledWord() {
        if (currentWord == null) return null;
        char[] chars = currentWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = (int) (Math.random() * chars.length);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
