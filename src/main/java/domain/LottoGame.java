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

    public Lottos buyLotto(int money, List<String> manualLottoCount) {
        final int tryNum = money / LOTTO_PRICE;
        final List<Lotto> manualLottos = manualLottoCount.stream()
                                                         .map(Lotto::new)
                                                         .collect(Collectors.toList());

        final int autoLottoCount = tryNum - manualLottoCount.size();
        final List<Lotto> autoLottos = Stream.generate(LottoGenerator::createLotto)
                                             .limit(autoLottoCount)
                                             .collect(Collectors.toList());
        autoLottos.addAll(manualLottos);
        lottos = new Lottos(autoLottos);
        return lottos;
    }

    public Lottos buyLotto(int money) {
        return buyLotto(money, List.of());
    }

    public Map<Rank, Long> checkWin(String wonLottoString, int bonusNumber) {
        final Lotto wonLotto = new Lotto(wonLottoString);
        return lottos.getMatchCount(wonLotto, bonusNumber);
    }
}
