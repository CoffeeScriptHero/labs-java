package lab3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int C3 = 1309 % 3; // 1  StringBuffer
        int C17 = 1309 % 17; //  0 Знайти найбільшу кількість речень заданого тексту, в яких є однакові слова.

        try {
            StringBuffer text1 = new StringBuffer("Hello: world??? World - is beautiful!");
            StringBuffer text2 = new StringBuffer("The cat loves to chase the mouse. Dogs chase cats, and cats chase mice." +
                " In the garden, the cat watches the mouse. Cats are good at chasing mice. The mouse is afraid of cats.");

            int maxSentencesNumber1 = getSentencesWithMostDuplicates(text1);
            int maxSentencesNumber2 = getSentencesWithMostDuplicates(text2);

            System.out.println("Max number of sentences with similar words (text1): " + maxSentencesNumber1);
            System.out.println("Max number of sentences with similar words (text2): " + maxSentencesNumber2);
        } catch (IllegalArgumentException e) {
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
            String sentence = sentences[i].replaceAll("[,-:]", " ");
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
