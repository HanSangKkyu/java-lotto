import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;

public class Lottos {
    private List<List<Integer>> lottos;

    public Lottos(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Map<Long, Long> getMatchCount(List<Integer> wonLotto) {
        return lottos.stream()
                .map(lotto -> intersectionNum(wonLotto, lotto))
                .filter(count -> count >= 3)
                .collect(groupingBy(count -> count, counting()));
    }

    private long intersectionNum(List<Integer> wonLotto, List<Integer> lotto) {
        return lotto.stream()
                .filter(wonLotto::contains)
                .count();
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }
}
