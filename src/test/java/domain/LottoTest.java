package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;

import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void constructUsingLottoNumbersString() {
        assertThat(new Lotto("1, 2, 3, 4, 5, 6")).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void lottoShouldHas6Items() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto("1, 2, 3, 4, 5"));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto("1, 2, 3, 4, 5, 6, 7"));
    }

    @Test
    void contains() {
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(1)).isEqualTo(true);
        assertThat(lotto.contains(7)).isEqualTo(false);
    }

    @Test
    void intersectionNum() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).intersectionNum(new Lotto(List.of(1, 2, 3, 7, 8, 9)))).isEqualTo(3);
    }
}
