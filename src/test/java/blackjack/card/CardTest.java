package blackjack.card;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {

    @Test
    void 카드_동등성() {
        Card cloverAce1 = Card.of(CardType.CLOVER, CardNumber.ACE);
        Card cloverAce2 = Card.of(CardType.CLOVER, CardNumber.ACE);

        assertThat(cloverAce1).isEqualTo(cloverAce2);
    }

    @Test
    void 카드_문자열() {
        Card cloverAce = Card.of(CardType.CLOVER, CardNumber.ACE);
        Card kingClover = Card.of(CardType.CLOVER, CardNumber.KING);
        Card tenClover = Card.of(CardType.CLOVER, CardNumber.TEN);

        assertThat(cloverAce.toString()).isEqualTo("A CLOVER");
        assertThat(kingClover.toString()).isEqualTo("K CLOVER");
        assertThat(tenClover.toString()).isEqualTo("10 CLOVER");

    }
}