package blackjack.players;

import blackjack.card.Card;
import org.junit.jupiter.api.Test;

import static blackjack.card.CardNumber.*;
import static blackjack.card.CardType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HoldingsTest {

    @Test
    void 총합_계산() {
        Holdings holdings = new Holdings();
        holdings.add(Card.of(SPADE, FIVE));
        holdings.add(Card.of(HEART, FIVE));
        holdings.add(Card.of(DIAMOND, ACE));
        holdings.add(Card.of(CLOVER, ACE));

        assertThat(holdings.maxTotal()).isEqualTo(12);
    }

    @Test
    void 총합21_초과시_카드_추가하면_예외() {
        Holdings holdings = new Holdings();
        holdings.add(Card.of(CLOVER, KING));
        holdings.add(Card.of(SPADE, KING));
        holdings.add(Card.of(HEART, KING));

        assertThatThrownBy(() -> {
            holdings.add(Card.of(DIAMOND, KING));
        }).isInstanceOf(IllegalStateException.class);
    }
}