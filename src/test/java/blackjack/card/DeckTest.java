package blackjack.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DeckTest {

    Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    void 덱_뽑기() {
        Card card = deck.draw();

        assertThat(card.number()).isBetween(1, 10);
    }

    @Test
    void 덱_뽑기_남은_카드_없으면_예외() {
        for (int i = 0; i < 52; i++) {
            deck.draw();
        }
        assertThatThrownBy(() -> {
            deck.draw();
        }).isInstanceOf(IllegalStateException.class);
    }
}
