package blackjack.state.finished;

import blackjack.card.Cards;

public class Bust extends Finished {

    public Bust(Cards cards) {
        super(cards);
    }

    @Override
    protected double earningRate() {
        return 0;
    }
}
