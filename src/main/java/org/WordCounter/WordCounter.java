package org.WordCounter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCounter {

    public static void main(String[] args) {
        String file = "../resources/file/words_file";

        try {
            Map<String, Integer> frequencyWords = new HashMap<>();
            int totalWords = 0;
            int totalCharacters = 0;

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    frequencyWords.put(word, frequencyWords.getOrDefault(word, 0) + 1);
                    totalWords++;
                    totalCharacters += word.length() + 1;
                }
                totalCharacters = totalCharacters - 1;
            }
            reader.close();

            System.out.println(totalWords + " words");
            System.out.println(totalCharacters + " characters");
            System.out.println(" ");

            List<Map.Entry<String, Integer>> listSorted = new ArrayList<>(frequencyWords.entrySet());
            listSorted.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            for (Map.Entry<String, Integer> entry : listSorted) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            System.err.println("Error when reading file: " + e.getMessage());
        }
    }
}