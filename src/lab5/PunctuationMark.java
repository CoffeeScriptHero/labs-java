package lab5;

public class PunctuationMark extends Character implements SentenceComponent {

    public PunctuationMark(char punctuationMark) {
        super(punctuationMark);
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }
}
