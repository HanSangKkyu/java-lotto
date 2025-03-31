package util;

import static domain.LottoGame.LOTTO_PRICE;

import java.util.Map;

import domain.Rank;

public final class LottoResult {

    public static double getEarnRate(Map<Rank, Long> matchCount) {
        final long totalWonMoney = matchCount.keySet().stream().map(x -> x.getWinningMoney() * matchCount.get(x)).reduce(Long::sum).orElse(0L);
        final long totalPaidMoney = matchCount.values().stream().reduce(Long::sum).orElse(0L) * LOTTO_PRICE;
        return Math.floor((double) totalWonMoney / totalPaidMoney * 100) / 100.0;
    }
}
