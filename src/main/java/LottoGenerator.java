import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LottoGenerator {
    private LottoGenerator() {}

    private static final List<Integer> lottoCandidateNumbers = Stream.iterate(1, i -> i + 1).limit(45).collect(Collectors.toList());

    public static List<Integer> createLottos() {
        Collections.shuffle(lottoCandidateNumbers);
        final List<Integer> pickedLottoNumbers = new ArrayList<>(lottoCandidateNumbers.subList(0, 6));
        pickedLottoNumbers.sort(Integer::compareTo);
        return pickedLottoNumbers;
    }
}
