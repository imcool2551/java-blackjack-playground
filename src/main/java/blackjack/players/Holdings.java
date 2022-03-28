package blackjack.players;

import blackjack.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Holdings {

    private final List<Card> cards;

    public Holdings() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        if (!canAddCard()) {
            throw new IllegalStateException("can't add more cards");
        }
        cards.add(card);
    }

    private boolean canAddCard() {
        return minTotal() < 21;
    }

    private int minTotal() {
        return normalCardTotal() + aceCount() * 1;
    }

    private int normalCardTotal() {
        int normalSum = cards.stream()
                .filter(card -> !card.isAce())
                .mapToInt(Card::number)
                .sum();

        return normalSum;
    }

    private int aceCount() {
        return (int) cards.stream()
                .filter(Card::isAce)
                .count();
    }

    public int maxTotal() {
        return IntStream.range(0, aceCount())
                .reduce(minTotal(), (total, current) -> upgradeAce(total));
    }

    private int upgradeAce(int total) {
        if (total + 10 < 21) {
            return total + 10;
        }
        return total;
    }

}
