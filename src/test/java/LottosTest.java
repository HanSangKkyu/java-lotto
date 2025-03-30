import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10))));
    }

    @Test
    void size() {
        assertThat(lottos.size()).isEqualTo(5);
    }

    @Test
    void getMatchCount() {
        final Map<Long, Long> matchCount = lottos.getMatchCount(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(matchCount.get(3L)).isEqualTo(1);
        assertThat(matchCount.get(4L)).isEqualTo(1);
        assertThat(matchCount.get(5L)).isEqualTo(1);
        assertThat(matchCount.get(6L)).isEqualTo(1);
    }
}
