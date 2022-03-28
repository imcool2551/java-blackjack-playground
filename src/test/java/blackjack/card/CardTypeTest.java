package blackjack.card;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardTypeTest {

    @Test
    void 카드_타입() {
        CardType[] cardTypes = CardType.values();

        assertThat(cardTypes.length).isEqualTo(4);
    }

}