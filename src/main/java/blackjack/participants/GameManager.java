package blackjack.participants;

import blackjack.card.Deck;

import java.util.List;

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

    public void initGame() {
        dealer.draw(deck.draw());
        dealer.draw(deck.draw());

        players.forEach(player -> {
            player.draw(deck.draw());
            player.draw(deck.draw());
        });

        outputReporter.reportInit(dealer, players);
    }

    public void giveExtraCards() {
        giveExtraCardsForPlayers();
        giveExtraCardsForDealer();
    }

    private void giveExtraCardsForDealer() {
        if (dealer.isFinished()) {
            stayAndReport(dealer);
            return;
        }
        drawAndReport(dealer);
    }

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

    private void drawAndReport(Participant participant) {
        participant.draw(deck.draw());
        outputReporter.reportCardsOf(participant);
    }

    private void stayAndReport(Participant participant) {
        participant.stay();
        outputReporter.reportCardsOf(participant);
    }

    public Participant getDealer() {
        return dealer;
    }
}
