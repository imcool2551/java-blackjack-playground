package blackjack.participants;

import java.util.List;
import java.util.Map;

public interface OutputReporter {

    void reportInit(Participant dealer, List<Participant> players);

    void reportCardsOf(Participant participant);

    void reportMidGame(Participant dealer, List<Participant> players);

    void reportResult(Map<Participant, Double> result);
}
