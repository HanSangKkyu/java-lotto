import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @Test
    void earnRate() {
        assertThat(new LottoResult(14, 1, 0, 0, 0)).isEqualTo(new LottoResult(14, 1, 0, 0, 0, 0.35));
    }
}