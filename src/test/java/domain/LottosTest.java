package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                    new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                    new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                                    new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                                    new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                                    new Lotto(List.of(1, 2, 7, 8, 9, 10))));
    }

    @Test
    void size() {
        assertThat(lottos.size()).isEqualTo(6);
    }

    @Test
    void getMatchCount() {
        final Map<Rank, Long> matchCount = lottos.getMatchCount(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        matchCount.keySet().forEach(x->
                System.out.println(x + " : " + matchCount.get(x) + ", ")
        );
        assertThat(matchCount.get(Rank.FIRST)).isEqualTo(1);
        assertThat(matchCount.get(Rank.SECOND)).isEqualTo(1);
        assertThat(matchCount.get(Rank.THIRD)).isEqualTo(1);
        assertThat(matchCount.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(matchCount.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(matchCount.get(Rank.MISS)).isEqualTo(1);
    }
}
