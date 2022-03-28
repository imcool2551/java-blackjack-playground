package blackjack.players;

import blackjack.card.Card;

public class Player implements Participant {

    private final String name;
    private final int battingPrice;
    private final Holdings holdings;

    //==생성 메서드==//
    public Player(String name, int battingPrice) {
        if (battingPrice < 0) {
            throw new IllegalArgumentException("battingPrice must be more than 0");
        }
        this.name = name;
        this.battingPrice = battingPrice;
        this.holdings = new Holdings();
    }

    //==공통 메서드==//

    //==비즈니스 로직==//


    @Override
    public void startGame(Card card1, Card card2) {
        holdings.add(card1);
        holdings.add(card2);
    }

    @Override
    public int total() {
        return 19;
    }
}
