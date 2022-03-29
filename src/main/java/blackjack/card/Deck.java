package blackjack.card;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Deck {

    private Stack<Card> cards = new Stack<>();

    //==생성 메서드==//
    public Deck() {
        initialize();
    }

    private void initialize() {
        Arrays.stream(CardType.values())
                .forEach(this::addCardsOfType);
        Collections.shuffle(cards);
    }

    private void addCardsOfType(CardType cardType) {
        Arrays.stream(CardNumber.values())
                .forEach(cardNumber -> cards.add(Card.of(cardType, cardNumber)));
    }

    //==비즈니스 로직==//
    public Card draw() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("there are no more cards left to draw");
        }
        return cards.pop();
    }
}
