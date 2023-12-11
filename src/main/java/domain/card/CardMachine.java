package domain.card;

import java.util.List;
import java.util.Random;

public class CardMachine {
    private List<Card> cards;

    public CardMachine() {
        cards = CardFactory.create();
    }

    public Card drawCard() {
        return cards.remove(new Random().nextInt(cards.size()));
    }
}
