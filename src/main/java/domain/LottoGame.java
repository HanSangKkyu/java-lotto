package domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import util.LottoGenerator;

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

    public Map<Rank, Long> checkWin(String wonLottoString, int bonusNumber) {
        final Lotto wonLotto = new Lotto(wonLottoString);
        return lottos.getMatchCount(wonLotto, bonusNumber);
    }
}
