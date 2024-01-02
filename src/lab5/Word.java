package lab5;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Word implements SentenceComponent {

    private final Letter[] letters;

    public Word(Letter[] letters) {
        this.letters = letters;
    }

    public String getStringRepresentation() {
        return Arrays.stream(letters)
            .map(letter -> String.valueOf(letter.getCharacter()))
            .collect(Collectors.joining());
    }

    @Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        Arrays.stream(letters).forEach(word::append);
        return word.toString();
    }
}
