package domain;

import static domain.Rank.SECOND_THIRD_MATCHING_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void valueOf() {
        assertThat(Rank.valueOf(SECOND_THIRD_MATCHING_COUNT, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(SECOND_THIRD_MATCHING_COUNT, false)).isEqualTo(Rank.THIRD);
    }
}
