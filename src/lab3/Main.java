package lab3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int C3 = 1309 % 3; // 1  StringBuffer
        int C17 = 1309 % 17; //  0 Знайти найбільшу кількість речень заданого тексту, в яких є однакові слова.

        try {
            StringBuffer text = new StringBuffer("Hello world. World is beautiful");
            int maxSentencesNumber = getSentencesWithMostDuplicates(text);
            System.out.println("Max number of sentences with similar words: " + maxSentencesNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getSentencesWithMostDuplicates(StringBuffer text) throws IllegalArgumentException {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text is null or empty");
        }

        String[] sentences = text.toString().split("[.!?]+\\s*");
        Map<String, Set<Integer>> wordFrequency = new HashMap<>();

        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i].replaceAll("[,\\-]", " ");
            String[] words = sentence.trim().split("\\s+");
            for (String word : words) {
                wordFrequency.computeIfAbsent(word.toLowerCase(), k -> new HashSet<>()).add(i);
            }
        }

        return wordFrequency.values().stream()
            .map(Set::size)
            .max(Integer::compareTo)
            .get();
    }
}
