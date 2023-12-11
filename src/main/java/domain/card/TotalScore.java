package domain.card;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TotalScore {
    private TotalScore() {
    }

    public static int getWorstTotal(List<Card> cards) {
        int totalScore = 0;
        for (Card card : cards) {
            totalScore += card.getScore();
        }
        return totalScore;
    }

    public static int getBestTotal(List<Card> cards) {
        int totalScore = getWorstTotal(cards);
        int aceCount = getAceCount(cards);
        while (totalScore <= 21 && aceCount != 0) {
            aceCount--;
            totalScore += 10;
        }
        return totalScore;
    }

    private static int getAceCount(List<Card> cards) {
        return (int) cards.stream()
                .map(Card::getScore)
                .filter(Predicate.isEqual(1))
                .count();
    }
}
