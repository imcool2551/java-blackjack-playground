package blackjack;

import blackjack.participants.GameManager;
import blackjack.participants.Participant;
import blackjack.ui.InputView;
import blackjack.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {

        // 참여자 입력
        List<Participant> players = inputView.promptInit();

        // 게임 시작 + 2장씩 배분
        GameManager manager = new GameManager(players, inputView, outputView);
        manager.initGame();

        // 추가 카드 배분
        manager.giveExtraCards();

        // 최종 결과 출력
        List<Participant> participants = new ArrayList<>(players);
        participants.add(manager.getDealer());
        outputView.printFinalCards(participants);

        // TODO: 최종 수익 계산 및 출력
    }


}
