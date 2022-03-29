package blackjack.state;

import blackjack.card.Cards;

public abstract class Started implements State {

    protected Cards cards;

    public Started(Cards cards) {
        this.cards = cards;
    }

    @Override
    public Cards cards() {
        return cards;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cards);
        sb.append("- 결과: ");
        sb.append(cards.maxTotal());
        return sb.toString();
    }
}
