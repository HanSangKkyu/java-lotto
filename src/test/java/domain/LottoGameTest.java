package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class LottoGameTest {
    @Test
    void buyLottoTest() {
        final LottoGame lottoGame = new LottoGame();
        assertThat(lottoGame.buyLotto(14000).size()).isEqualTo(14);
    }

    @Test
    void checkWin() {
        final Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(23, 25, 33, 36, 39, 41)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45)),
                new Lotto(List.of(5, 9, 38, 41, 43, 44)),
                new Lotto(List.of(2, 8, 9, 18, 19, 21)),
                new Lotto(List.of(13, 14, 18, 21, 23, 35)),
                new Lotto(List.of(17, 21, 29, 37, 42, 45)),
                new Lotto(List.of(3, 8, 27, 30, 35, 44))
        ));
        final LottoGame lottoGame = new LottoGame(lottos);
        final Map<Rank, Long> rankToMatchCount = lottoGame.checkWin("1, 2, 3, 4, 5, 6", 7);
        assertThat(rankToMatchCount.get(Rank.FIFTH)).isEqualTo(1L);
        assertThat(rankToMatchCount.get(Rank.MISS)).isEqualTo(13L);
    }
}
