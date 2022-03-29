package blackjack.state;

import blackjack.card.Card;
import blackjack.card.Cards;

public interface State {

    boolean isFinished();

    double profit(double battingPrice);

    Cards cards();

    State stay();

    State draw(Card card);
}
