import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {
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
        lottos = new Lottos(Stream.generate(LottoGenerator::createLotto).limit(tryNum).collect(Collectors.toList()));
        return lottos;
    }

    public LottoResult checkWin(String wonLottoString) {
        Lotto wonLotto = new Lotto(wonLottoString);

        final Map<Long, Long> matchCount = lottos.getMatchCount(wonLotto);

        return new LottoResult(lottos.size(), matchCount.getOrDefault(3L, 0L), matchCount.getOrDefault(4L, 0L), matchCount.getOrDefault(5L, 0L), matchCount.getOrDefault(6L, 0L));
    }
}
