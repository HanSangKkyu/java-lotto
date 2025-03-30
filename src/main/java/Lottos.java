import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Map<Long, Long> getMatchCount(Lotto wonLotto) {
        return lottos.stream()
                .map(wonLotto::intersectionNum)
                .filter(count -> count >= 3)
                .collect(groupingBy(count -> count, counting()));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
