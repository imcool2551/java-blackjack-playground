package blackjack.players;

import blackjack.card.Card;

public interface Participant {

    void add(Card card);

    int result();
}
