package blackjack.state.finished;

import blackjack.card.Cards;

public class Stay extends Finished {

    public Stay(Cards cards) {
        super(cards);
    }

    @Override
    protected double earningRate() {
        return 1;
    }

}
