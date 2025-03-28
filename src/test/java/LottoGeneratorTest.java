import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {


    @Test
    void createLottos() {
        final List<Integer> lottos = LottoGenerator.createLottos();
        assertThat(lottos.size()).isEqualTo(6);
    }
}
