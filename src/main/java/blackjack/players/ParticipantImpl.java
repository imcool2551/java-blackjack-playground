package blackjack.players;

import blackjack.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParticipantImpl implements Participant {

    private static final int ACE_BONUS = 10;
    private static final int MAX_TOTAL = 21;
    private final List<Card> cards;

    public ParticipantImpl(Card card1, Card card2) {
        this.cards = new ArrayList<>();
        add(card1);
        add(card2);
    }

    @Override
    public void add(Card card) {
        if (aceAsOne() >= MAX_TOTAL) {
            throw new IllegalStateException("can't add more cards");
        }

        cards.stream()
                .filter(c -> c.equals(card))
                .findAny()
                .ifPresent(c -> {
                    throw new IllegalStateException("can't add duplicate card");
                });

        cards.add(card);
    }

    @Override
    public int result() {
        return IntStream.range(0, aceCount())
                .reduce(aceAsOne(), (total, __) -> {
                    if (total + ACE_BONUS <= 21) {
                        return total + ACE_BONUS;
                    }
                    return total;
                });
    }

    private int aceAsOne() {
        int normalSum = cards.stream()
                .filter(card -> !card.isAce())
                .mapToInt(Card::number)
                .sum();

        return normalSum + aceCount() * 1;
    }

    private int aceCount() {
        return (int) cards.stream()
                .filter(Card::isAce)
                .count();
    }

}
