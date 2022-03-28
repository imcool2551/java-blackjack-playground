package blackjack.card;

import java.util.EnumSet;

public enum CardNumber {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    KING(10),
    QUEEN(10),
    JACK(10);

    private static EnumSet<CardNumber> specialCards = EnumSet.of(ACE, KING, QUEEN, JACK);
    private final int number;

    //==생성 메서드==//
    CardNumber(int number) {
        this.number = number;
    }

    //==공통 메서드==//
    @Override
    public String toString() {
        if(specialCards.contains(this)) {
            return String.valueOf(this.name().charAt(0));
        }
        return String.valueOf(this.getNumber());
    }

    //==비즈니스 로직==//
    public int getNumber() {
        return number;
    }

    public boolean isAce() {
        return this == ACE;
    }
}
