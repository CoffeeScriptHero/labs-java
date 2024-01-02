package lab5;

import java.util.Arrays;

public class Sentence {

    private SentenceComponent[] sentenceComponents;

    public Sentence(SentenceComponent[] sentenceComponents) {
        this.sentenceComponents = sentenceComponents;
    }

    public SentenceComponent[] getSentenceComponents() {
        return sentenceComponents;
    }

    public void deletePunctuationMarks() {
        sentenceComponents = Arrays.stream(sentenceComponents)
            .filter(sentenceComponent -> sentenceComponent instanceof Word)
            .toArray(SentenceComponent[]::new);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(sentenceComponents).forEach(sb::append);
        return sb.toString();
    }
}
