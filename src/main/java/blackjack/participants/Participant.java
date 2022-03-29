package blackjack.participants;

import blackjack.card.Card;
import blackjack.card.Cards;
import blackjack.state.State;
import blackjack.state.running.Hit;

public abstract class Participant implements State {

    protected State state;

    public Participant() {
        this.state = new Hit(Cards.emptyCards());
    }

    public abstract String getName();

    @Override
    public State draw(Card card) {
        this.state = this.state.draw(card);
        return state;
    }

    @Override
    public Cards cards() {
        return state.cards();
    }

    @Override
    public State stay() {
        this.state = state.stay();
        return state;
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
