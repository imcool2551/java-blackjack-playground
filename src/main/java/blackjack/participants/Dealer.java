package blackjack.participants;

public class Dealer extends Participant {

    private static final int DEALER_UPPER_BOUND = 17;

    //==비즈니스 로직==//
    @Override
    public String getName() {
        return "딜러";
    }

    @Override
    public boolean isFinished() {
        if (cards().size() == 2 && cards().maxTotal() < DEALER_UPPER_BOUND) {
            return false;
        }
        return true;
    }

    @Override
    public double profit() {
        return 0;
    }

    @Override
    public double battingPrice() {
        return 0;
    }
}
