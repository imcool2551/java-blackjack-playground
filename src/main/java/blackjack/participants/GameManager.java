package blackjack.participants;

import blackjack.card.Deck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class GameManager {

    private final List<Participant> players;
    private final Participant dealer;
    private final Deck deck;

    private final InputReporter inputReporter;
    private final OutputReporter outputReporter;

    public GameManager(List<Participant> players,
                       InputReporter inputReporter,
                       OutputReporter outputReporter) {

        this.players = players;
        this.dealer = new Dealer();
        this.deck = new Deck();
        this.inputReporter = inputReporter;
        this.outputReporter = outputReporter;
    }

    public void startGame() {
        init();
        proceed();
        finish();
    }

    private void init() {
        dealer.draw(deck.draw());
        dealer.draw(deck.draw());

        players.forEach(player -> {
            player.draw(deck.draw());
            player.draw(deck.draw());
        });

        outputReporter.reportInit(dealer, players);
    }

    private void proceed() {
        giveExtraCardsForPlayers();
        giveExtraCardsForDealer();

        outputReporter.reportMidGame(dealer, players);
    }

    private void finish() {
        if (dealer.cards().isBlackJack()) {
            outputReporter.reportResult(handleDealerBlackJack());
            return;
        }
        if (dealer.cards().isBust()) {
            outputReporter.reportResult(handleDealerBust());
            return;
        }
        outputReporter.reportResult(handleDealerHit());
    }


    //==카드 추가 로직==//
    private void giveExtraCardsForPlayers() {
        players.forEach(player -> {
            while (!player.isFinished()) {
                if (inputReporter.isWillingToDraw(player)) {
                    drawAndReport(player);
                } else {
                    stayAndReport(player);
                }
            }
        });
    }

    private void giveExtraCardsForDealer() {
        if (dealer.isFinished()) {
            stayAndReport(dealer);
            return;
        }
        drawAndReport(dealer);
    }

    private void drawAndReport(Participant participant) {
        participant.draw(deck.draw());
        outputReporter.reportCardsOf(participant);
    }

    private void stayAndReport(Participant participant) {
        participant.stay();
        outputReporter.reportCardsOf(participant);
    }

    //==결과 계산 로직==//
    private Map<Participant, Double> handleDealerBlackJack() {
        Map<Participant, Double> profits = new HashMap<>();
        addDrawerProfit(p -> p.cards().isBlackJack(), profits);
        addLoserProfit(p -> !p.cards().isBlackJack(), profits);
        addDealerProfit(profits);
        return profits;
    }

    private Map<Participant, Double> handleDealerBust() {
        Map<Participant, Double> profits = new HashMap<>();
        addWinnerProfit(p -> !p.cards().isBust(), profits);
        addLoserProfit(p -> p.cards().isBust(), profits);
        addDealerProfit(profits);
        return profits;
    }

    private Map<Participant, Double> handleDealerHit() {
        Map<Participant, Double> profits = new HashMap<>();

        int winnerNumber = Math.max(players.stream()
                .filter(p -> !p.cards().isBust())
                .mapToInt(p -> p.cards().maxTotal())
                .max()
                .orElse(0), dealer.cards().maxTotal());

        addWinnerProfit(p -> p.cards().maxTotal() == winnerNumber, profits);
        addLoserProfit(p -> p.cards().maxTotal() != winnerNumber, profits);
        addDealerProfit(profits);
        return profits;
    }

    private void addWinnerProfit(Predicate<Participant> winCondition, Map<Participant, Double> profits) {
        players.stream()
                .filter(winCondition)
                .forEach(p -> profits.put(p, p.battingPrice()));
    }

    private void addDrawerProfit(Predicate<Participant> drawCondition, Map<Participant, Double> profits) {
        players.stream()
                .filter(drawCondition)
                .forEach(p -> profits.put(p, 0d));
    }

    private void addLoserProfit(Predicate<Participant> loseCondition, Map<Participant, Double> profits) {
        players.stream()
                .filter(loseCondition)
                .forEach(p -> profits.put(p, -p.battingPrice()));
    }

    private void addDealerProfit(Map<Participant, Double> profits) {
        double playersTotalProfit = profits.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        profits.put(dealer, -playersTotalProfit);
    }
}
