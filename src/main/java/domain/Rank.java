package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    public static final int SECOND_THIRD_MATCHING_COUNT = 5;
    private final int countOfMatch;
    private final int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(long countOfMatch, boolean matchBonus) {
        validCountOfMatch(countOfMatch);
        if (countOfMatch == SECOND_THIRD_MATCHING_COUNT) {
            if (matchBonus) {
                return SECOND;
            }
            return THIRD;
        }
        return Arrays.stream(values())
                     .filter(x -> x.countOfMatch == countOfMatch)
                     .findFirst()
                     .orElse(MISS);
    }

    private static void validCountOfMatch(long countOfMatch) {
        if (countOfMatch < 0 || countOfMatch > 6) {
            throw new IllegalArgumentException("countOfMatch must be between 0 and 6");
        }
    }
}
