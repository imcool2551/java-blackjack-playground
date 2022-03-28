package blackjack.players;

import blackjack.card.Deck;

import java.util.List;

public class Dealer {
    private final List<Player> players;
    private final Deck deck;
    private final Holdings holdings;

    //==생성 메서드==//
    public Dealer(List<Player> players) {
        this.players = players;
        deck = new Deck();
        this.holdings = new Holdings();
    }

    //==비즈니스 로직==//
}
