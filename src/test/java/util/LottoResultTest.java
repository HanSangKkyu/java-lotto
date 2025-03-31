package util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;

import domain.Rank;

class LottoResultTest {
    @Test
    void earnRate() {
        assertThat(LottoResult.getEarnRate(Map.of(Rank.FIFTH, 1L, Rank.MISS, 13L))).isEqualTo(0.35);
    }
}
