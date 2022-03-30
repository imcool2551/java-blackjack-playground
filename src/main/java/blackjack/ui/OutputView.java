package blackjack.ui;

import blackjack.participants.Dealer;
import blackjack.participants.OutputReporter;
import blackjack.participants.Participant;

import java.util.List;

public class OutputView implements OutputReporter {

    @Override
    public void reportInit(Participant dealer, List<Participant> players) {
        System.out.println();
        System.out.println("=========GAME START=========");
        System.out.println();

        System.out.println("딜러와 플레이어들에게 2장씩 나누었습니다.");
        System.out.println();
        printCurrentCardsOf(dealer);
        players.forEach(this::printCurrentCardsOf);

        System.out.println();
    }

    @Override
    public void reportCardsOf(Participant participant) {
        if (participant instanceof Dealer) {
             System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
             System.out.println();
             return;
        }

        printCurrentCardsOf(participant);
    }

    @Override
    public void reportMidGame(Participant dealer, List<Participant> players) {
        printFinalCards(dealer);
        players.forEach(System.out::println);
    }

    public void printFinalCards(Participant participant) {
        System.out.println(participant);
    }

    private void printCurrentCardsOf(Participant participant) {
        System.out.println(participant.getName() + ": " + participant.cards());
    }
}
