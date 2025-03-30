import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {
    public static final String DELIMITER = ", ";
    public static final int LOTTO_PRICE = 1000;
    private Lottos lottos;

    public LottoGame(Lottos lottos) {
        this.lottos = lottos;
    }

    public LottoGame() {
        this(new Lottos(List.of()));
    }

    public Lottos buyLotto(int money) {
        final int tryNum = money / LOTTO_PRICE;
        lottos = new Lottos(Stream.generate(LottoGenerator::createLottos).limit(tryNum).collect(Collectors.toList()));
        return lottos;
    }

    public LottoResult checkWin(String wonLottoString) {
        List<Integer> wonLotto = Stream.of(wonLottoString.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        final Map<Long, Long> matchCount = lottos.getMatchCount(wonLotto);

        return new LottoResult(lottos.size(), matchCount.getOrDefault(3L, 0L), matchCount.getOrDefault(4L, 0L), matchCount.getOrDefault(5L, 0L), matchCount.getOrDefault(6L, 0L));
    }
}
