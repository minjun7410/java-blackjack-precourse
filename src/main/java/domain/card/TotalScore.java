package domain.card;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TotalScore {
    private final List<Card> cards;

    public TotalScore(List<Card> cards) {
        this.cards = cards;
    }

    public int getWorstTotal() {
        int totalScore = 0;
        for (Card card : cards) {
            totalScore += card.getScore();
        }
        return totalScore;
    }

    public int getBestTotal() {
        int totalScore = getWorstTotal();
        int aceCount = getAceCount();
        while (totalScore <= 21 && aceCount != 0) {
            aceCount--;
            totalScore += 10;
        }
        return totalScore;
    }

    private int getAceCount() {
        return (int) cards.stream()
                .map(Card::getScore)
                .filter(Predicate.isEqual(1))
                .count();
    }
}
