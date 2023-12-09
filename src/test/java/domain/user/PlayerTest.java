package domain.user;

import domain.card.Card;
import domain.card.CardFactory;
import domain.card.Symbol;
import domain.card.Type;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {
    @Test
    void 카드를_더_받을_수_있는_플레이어인가() {
        Player player = new Player("minjun", 10000);
        player.addCard(new Card(Symbol.JACK, Type.CLUB));
        assertThat(player.canDraw()).isTrue();
    }

    @Test
    void 카드를_더_받을_수_없는_플레이어인가() {
        Player player = new Player("minjun", 10000);
        player.addCard(new Card(Symbol.JACK, Type.CLUB));
        player.addCard(new Card(Symbol.JACK, Type.CLUB));
        player.addCard(new Card(Symbol.JACK, Type.CLUB));
        assertThat(player.canDraw()).isFalse();
    }
}
