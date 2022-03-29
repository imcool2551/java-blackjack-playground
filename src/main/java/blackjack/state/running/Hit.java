package blackjack.state.running;

import blackjack.card.Card;
import blackjack.card.Cards;
import blackjack.state.State;
import blackjack.state.finished.Blackjack;
import blackjack.state.finished.Bust;
import blackjack.state.finished.Stay;

public class Hit extends Running {

    public Hit(Cards cards) {
        super(cards);
    }

    @Override
    public State stay() {
        if (cards().isBlackJack()) {
            return new Blackjack(cards());
        }
        return new Stay(cards());
    }

    @Override
    public State draw(Card card) {
        cards().add(card);
        if (cards().isBust()) {
            return new Bust(cards());
        }
        return new Hit(cards());
    }

}
