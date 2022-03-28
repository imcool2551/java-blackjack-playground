package blackjack.players;

import blackjack.card.Card;
import org.junit.jupiter.api.Test;

import static blackjack.card.CardNumber.NINE;
import static blackjack.card.CardNumber.TEN;
import static blackjack.card.CardType.CLOVER;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    void 플레이어_시작_카드_2장_총합() {
        Participant player = new Player("pobi", 10000);

        player.startGame(Card.of(CLOVER, TEN), Card.of(CLOVER, NINE));

        assertThat(player.total()).isEqualTo(19);
    }
}
