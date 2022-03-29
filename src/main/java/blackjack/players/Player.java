package blackjack.players;

import blackjack.card.Card;

public class Player implements Participant {

    private final String name;
    private final int battingPrice;
    private final Participant participant;

    //==생성 메서드==//
    public Player(String name, int battingPrice, Participant participant) {
        assert battingPrice > 0;
        this.name = name;
        this.battingPrice = battingPrice;
        this.participant = participant;
    }

    //==공통 메서드==//


    //==비즈니스 로직==//
    @Override
    public void add(Card card) {
        participant.add(card);
    }

    @Override
    public int result() {
        return participant.result();
    }

}
