package blackjack.state.finished;

import blackjack.card.Card;
import blackjack.card.Cards;
import blackjack.state.Started;
import blackjack.state.State;

public abstract class Finished extends Started {

    public Finished(Cards cards) {
        super(cards);
    }

    protected abstract double earningRate();

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public double profit(double battingPrice) {
        return battingPrice * earningRate();
    }

    @Override
    public State stay() {
        throw new IllegalStateException();
    }

    @Override
    public State draw(Card card) {
        throw new IllegalStateException();
    }
}
