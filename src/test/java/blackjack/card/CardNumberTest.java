package blackjack.card;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardNumberTest {

    @Test
    void 카드_숫자() {
        CardNumber[] cardNumbers = CardNumber.values();

        assertThat(cardNumbers.length).isEqualTo(13);
        assertThat(cardNumbers).allMatch(cardNumber -> {
            int value = cardNumber.getNumber();
            return value >= 1 && value <= 10;
        });
    }
}