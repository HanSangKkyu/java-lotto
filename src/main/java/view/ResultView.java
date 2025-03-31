package view;

import java.util.Arrays;
import java.util.Map;

import domain.Lottos;
import domain.Rank;
import util.LottoResult;

public final class ResultView {
    private ResultView() {}

    public static void printBuyLottoResult(Lottos lottos) {
        System.out.println("로또 구입을 " + lottos.size() + "개를 구매했습니다.");
        lottos.getLottos().forEach(System.out::println);
    }

    public static void printWonResult(Map<Rank, Long> matchCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(Rank.values()).forEach(x -> {
            if (x == Rank.MISS) {
                return;
            }
            System.out.println(x.getCountOfMatch() + "개 일치" + (x == Rank.SECOND ? ", 보너스 볼 일치" : "") + " (" + x.getWinningMoney() + "원)- " + matchCount.getOrDefault(x, 0L) + "개");
        });
        System.out.println("총 수익률은 " + LottoResult.getEarnRate(matchCount) + "입니다.");
    }
}
