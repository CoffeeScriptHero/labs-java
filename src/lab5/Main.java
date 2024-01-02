package lab5;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int C3 = 1309 % 3; // 1  StringBuffer
        int C17 = 1309 % 17; //  0 Знайти найбільшу кількість речень заданого тексту, в яких є однакові слова.

        SentenceComponent word1 = new Word(
            new Letter[]{new Letter('H'), new Letter('e'), new Letter('l'), new Letter('l'), new Letter('o')}
        );
        SentenceComponent word2 = new Word(
            new Letter[]{new Letter('w'), new Letter('o'), new Letter('r'), new Letter('l'), new Letter('d')}
        );
        SentenceComponent word3 = new Word(
            new Letter[]{new Letter('W'), new Letter('o'), new Letter('r'), new Letter('l'), new Letter('d')}
        );
        SentenceComponent word4 = new Word(
            new Letter[]{new Letter('i'), new Letter('s')}
        );
        SentenceComponent word5 = new Word(
            new Letter[]{
                new Letter('b'), new Letter('e'), new Letter('a'), new Letter('u'), new Letter('t'),
                new Letter('i'), new Letter('f'), new Letter('u'), new Letter('l')
            }
        );
        SentenceComponent word6 = new Word(
            new Letter[]{new Letter('w'), new Letter('o'), new Letter('r'), new Letter('l'), new Letter('d')}
        );

        SentenceComponent[] firstSentenceComponents =
            {word1, new PunctuationMark(','), new PunctuationMark(' '), word2, new PunctuationMark('.')};
        SentenceComponent[] secondSentenceComponents =
            {new PunctuationMark(' '), word3, new PunctuationMark(' '), word4, new PunctuationMark(' '), word5, new PunctuationMark('!')};
        SentenceComponent[] thirdSentenceComponents =
            {new PunctuationMark(' '), word6, new PunctuationMark('?')};


        Sentence firstSentence = new Sentence(firstSentenceComponents);
        Sentence secondSentence = new Sentence(secondSentenceComponents);
        Sentence thirdSentence = new Sentence(thirdSentenceComponents);
        Text text1 = new Text(new Sentence[]{firstSentence, secondSentence, thirdSentence});

        System.out.println(text1);
        System.out.println("Max number of sentences with similar words: " + getSentencesWithMostDuplicates(text1));
    }

    public static int getSentencesWithMostDuplicates(Text text) throws IllegalArgumentException {
        Sentence[] sentences = text.getSentences();
        Map<String, Set<Integer>> wordFrequency = new HashMap<>();

        for (int i = 0; i < sentences.length; ++i) {
            int index = i;
            Sentence sentence = sentences[index];
            sentence.deletePunctuationMarks();

            Arrays.stream(sentence.getSentenceComponents())
                .map(sentenceComponent -> (Word) sentenceComponent)
                .map(Word::getStringRepresentation)
                .forEach(word -> wordFrequency.computeIfAbsent(word.toLowerCase(), k -> new HashSet<>()).add(index));
        }

        return wordFrequency.values().stream()
            .map(Set::size)
            .max(Integer::compareTo)
            .get();
    }
}
