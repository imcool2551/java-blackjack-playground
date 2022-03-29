package blackjack.card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Cards  {

    private static final int ACE_BONUS = 10;
    private static final int BLACK_JACK = 21;
    private final List<Card> cards = new ArrayList<>();


    //==생성 메서드==//
    public static Cards emptyCards() {
        return new Cards();
    }

    //==비즈니스 로직==//
    public void add(Card card) {
        if (aceAsOne() >= BLACK_JACK) {
            throw new IllegalStateException("can't add more cards");
        }

        cards.stream()
                .filter(c -> c.equals(card))
                .findAny()
                .ifPresent(c -> {
                    throw new IllegalStateException("can't add duplicate card " + c);
                });

        cards.add(card);
    }

    public int maxTotal() {
        return IntStream.range(0, aceCount())
                .reduce(aceAsOne(), (total, __) -> {
                    if (total + ACE_BONUS <= BLACK_JACK) {
                        return total + ACE_BONUS;
                    }
                    return total;
                });
    }

    public boolean isBust() {
        return aceAsOne() > BLACK_JACK;
    }

    public boolean isBlackJack() {
        return cards.size() == 2 && maxTotal() == BLACK_JACK;
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

    public int size() {
        return cards.size();
    }

    //==공통 메서드==//
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString() + " ");
        }
        return sb.toString();
    }

}
