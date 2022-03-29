package blackjack.players;

import blackjack.card.Card;
import blackjack.card.Deck;

import java.util.List;

public class Dealer implements Participant {
    private final List<Player> players;
    private final Deck deck;
    private final Participant participant;

    //==생성 메서드==//
    public Dealer(List<Player> players, Deck deck, Participant participant) {
        this.players = players;
        this.deck = deck;
        this.participant = participant;
    }


    //==비즈니스 로직==//
    @Override
    public void add(Card card) {
        participant.add(card);
    }

    @Override
    public int result() {
        return participant.result();
    }
}
