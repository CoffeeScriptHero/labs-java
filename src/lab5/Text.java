package lab5;

import java.util.Arrays;

public class Text {

    private final Sentence[] sentencesArray;

    public Text(Sentence sentence) {
        this.sentencesArray = new Sentence[]{sentence};
    }

    public Text(Sentence[] sentencesArray) {
        this.sentencesArray = sentencesArray;
    }

    public Sentence[] getSentences() {
        return sentencesArray;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        Arrays.stream(sentencesArray).forEach(text::append);
        return text.toString();
    }
}
