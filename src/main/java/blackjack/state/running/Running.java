package blackjack.state.running;

import blackjack.card.Cards;
import blackjack.state.Started;

public abstract class Running extends Started {

    public Running(Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public double profit(double battingPrice) {
        throw new IllegalStateException();
    }

}
