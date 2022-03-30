package blackjack.participants;

import blackjack.card.Card;
import blackjack.card.Cards;
import blackjack.state.State;
import blackjack.state.running.Hit;

public abstract class Participant {

    protected State state;

    public Participant() {
        this.state = new Hit(Cards.emptyCards());
    }

    public abstract String getName();

    public abstract boolean isFinished();

    public abstract double profit();

    public abstract double battingPrice();

    public Cards cards() {
        return state.cards();
    }

    public State stay() {
        return state = state.stay();
    }

    public State draw(Card card) {
        return state = state.draw(card);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append("카드: ");
        sb.append(state.toString());
        return sb.toString();
    }

}
