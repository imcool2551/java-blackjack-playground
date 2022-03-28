package blackjack.players;

import blackjack.card.Card;

public interface Participant {

    void startGame(Card card1, Card card2);

    int total();
}
