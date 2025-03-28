import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {
    public static final String DELIMITER = ", ";
    private Lottos lottos;
    private List<Integer> wonLotto;

    public LottoGame(Lottos lottos) {
        this.lottos = lottos;
    }

    public LottoGame() {
        this(new Lottos(List.of()));
    }

    public Lottos buyLotto(int money) {
        final int tryNum = money / 1000;
        lottos = new Lottos(Stream.generate(LottoGenerator::createLottos).limit(tryNum).collect(Collectors.toList()));
        return lottos;
    }

    public LottoResult checkWin(String wonLottoString) {
        wonLotto = Stream.of(wonLottoString.split(DELIMITER))
                         .map(Integer::parseInt)
                         .collect(Collectors.toList());

        final Map<Long, Long> matchCount = lottos.getMatchCount(wonLotto);


        final double earnRate = (double) (matchCount.getOrDefault(3L, 0L) * 5000 +
                                          matchCount.getOrDefault(4L, 0L) * 50000 +
                                          matchCount.getOrDefault(5L, 0L) * 1500000 +
                                          matchCount.getOrDefault(6L, 0L) * 2000000000) / (lottos.size() * 1000L);
        final double formattedEarnRate = Math.floor(earnRate * 100) / 100.0;

        return new LottoResult(matchCount.getOrDefault(3L, 0L), matchCount.getOrDefault(4L, 0L), matchCount.getOrDefault(5L, 0L), matchCount.getOrDefault(6L, 0L), formattedEarnRate);
    }
}
