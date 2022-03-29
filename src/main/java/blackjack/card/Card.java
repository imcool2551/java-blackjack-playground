package blackjack.card;

import java.util.Objects;

public class Card {
    private final CardType cardType;
    private final CardNumber cardNumber;

    //==생성 메서드==//
    private Card(CardType cardType, CardNumber cardNumber) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }

    public static Card of(CardType cardType, CardNumber cardNumber) {
        return new Card(cardType, cardNumber);
    }

    //==비즈니스 로직==//
    public int number() {
        return cardNumber.getNumber();
    }

    public boolean isAce() {
        return cardNumber.isAce();
    }

    //==공통 메서드==//
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardType == card.cardType && cardNumber == card.cardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardType, cardNumber);
    }

    @Override
    public String toString() {
        return cardNumber.toString() + cardType.toString();
    }
}
