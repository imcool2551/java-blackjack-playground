package blackjack.ui;

import blackjack.participants.InputReporter;
import blackjack.participants.Participant;
import blackjack.participants.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView implements InputReporter {

    private Scanner scanner = new Scanner(System.in);

    public List<Participant> promptInit() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String[] names = scanner.next().split(",");
        System.out.println();

        List<Participant> players = new ArrayList<>();
        Arrays.stream(names)
                .forEach(name -> {
                    int battingPrice = promptBattingPrice(name);
                    players.add(new Player(name, battingPrice));
                });

        return players;
    }

    private int promptBattingPrice(String name) {
        System.out.println(name + "의 배팅 금액은?");
        return scanner.nextInt();
    }

    @Override
    public boolean isWillingToDraw(Participant participant) {
        System.out.println(participant.getName() + "는 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        String input = scanner.next();
        if (input.equals("y")) {
            return true;
        }
        if (input.equals("n")) {
            return false;
        }
        throw new IllegalArgumentException("Unexpected value: " + scanner.next());
    }
}
