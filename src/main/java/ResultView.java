import java.util.List;

public final class ResultView {
    private ResultView() {}

    public static void printBuyLottoResult(Lottos lottos) {
        System.out.println("로또 구입을 " + lottos.size() + "개를 구매했습니다.");
        lottos.getLottos().forEach(System.out::println);
    }

    public static void printWonResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)-" + lottoResult.getWin3Num() + "개");
        System.out.println("4개 일치 (50000원)-" + lottoResult.getWin4Num() + "개");
        System.out.println("5개 일치 (1500000원)-" + lottoResult.getWin5Num() + "개");
        System.out.println("6개 일치 (2000000000원)-" + lottoResult.getWin6Num() + "개");
        System.out.println("총 수익률은 " + lottoResult.getEarnRate() + "입니다.");
    }
}
