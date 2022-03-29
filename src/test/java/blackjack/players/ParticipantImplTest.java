package blackjack.players;

import blackjack.card.Card;
import org.junit.jupiter.api.Test;

import static blackjack.card.CardNumber.*;
import static blackjack.card.CardType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantImplTest {

    @Test
    void 총합_계산_에이스_11() {
        ParticipantImpl holdings = new ParticipantImpl(Card.of(SPADE, EIGHT), Card.of(SPADE, TWO));

        holdings.add(Card.of(SPADE, ACE));

        assertThat(holdings.result()).isEqualTo(21);
    }

    @Test
    void 총합_계산_에이스_1() {
        ParticipantImpl holdings = new ParticipantImpl(Card.of(SPADE, TEN), Card.of(HEART, NINE));

        holdings.add(Card.of(DIAMOND, ACE));
        holdings.add(Card.of(CLOVER, ACE));

        assertThat(holdings.result()).isEqualTo(21);
    }

    @Test
    void 총합21_초과시_카드_추가하면_예외() {
        ParticipantImpl holdings = new ParticipantImpl(Card.of(CLOVER, KING), Card.of(SPADE, KING));
        holdings.add(Card.of(HEART, KING));

        assertThatThrownBy(() -> {
            holdings.add(Card.of(DIAMOND, KING));
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 중복_카드_추가하면_예외() {
        assertThatThrownBy(() -> {
            new ParticipantImpl(Card.of(DIAMOND, KING), Card.of(DIAMOND, KING));
        }).isInstanceOf(IllegalStateException.class);
    }
}