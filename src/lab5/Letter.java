package lab5;

public class Letter extends Character {

    public Letter(char letter) {
        super(letter);
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }
}
