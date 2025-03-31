package domain;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Map<Rank, Long> getMatchCount(Lotto wonLotto, int bonusNumber) {
        return lottos.stream()
                     .map(x -> Rank.valueOf(x.intersectionNum(wonLotto), x.contains(bonusNumber)))
                     .collect(groupingBy(identity(), counting()));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
