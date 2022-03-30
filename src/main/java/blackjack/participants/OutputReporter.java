package blackjack.participants;

import java.util.List;

public interface OutputReporter {

    void reportInit(Participant dealer, List<Participant> players);

    void reportCardsOf(Participant participant);

    void reportMidGame(Participant dealer, List<Participant> players);
}
