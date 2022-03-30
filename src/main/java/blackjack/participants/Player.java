package blackjack.participants;

public class Player extends Participant {

    private final String name;
    private final int battingPrice;

    //==생성 메서드==//
    public Player(String name, int battingPrice) {
        this.name = name;
        this.battingPrice = battingPrice;
    }

    //==비즈니스 로직==//
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isFinished() {
        return state.isFinished();
    }

    @Override
    public double profit() {
        return state.profit(battingPrice());
    }

    @Override
    public double battingPrice() {
        return battingPrice;
    }
}
