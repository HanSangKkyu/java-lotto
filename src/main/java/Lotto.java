import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    public static final String DELIMITER = ", ";
    public static final int CORRECT_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != CORRECT_SIZE) {
            throw new IllegalArgumentException("should have 6 numbers");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String lottoNumbersString) {
        this(Arrays.stream(lottoNumbersString.split(DELIMITER)).map(Integer::parseInt).collect(Collectors.toList()));
    }

    public boolean contains(int value) {
        return this.lottoNumbers.contains(value);
    }

    public long intersectionNum(Lotto lotto) {
        return this.lottoNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }
}
