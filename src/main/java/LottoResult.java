import java.util.Objects;

public class LottoResult {
    private long win3Num;
    private long win4Num;
    private long win5Num;
    private long win6Num;
    private Double earnRate;

    public LottoResult(long win3Num, long win4Num, long win5Num, long win6Num, Double earnRate) {
        this.win3Num = win3Num;
        this.win4Num = win4Num;
        this.win5Num = win5Num;
        this.win6Num = win6Num;
        this.earnRate = earnRate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {return false;}
        final LottoResult that = (LottoResult) o;
        return win3Num == that.win3Num && win4Num == that.win4Num && win5Num == that.win5Num && win6Num == that.win6Num && Objects.equals(earnRate, that.earnRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(win3Num, win4Num, win5Num, win6Num, earnRate);
    }

    public long getWin3Num() {
        return win3Num;
    }

    public long getWin4Num() {
        return win4Num;
    }

    public long getWin5Num() {
        return win5Num;
    }

    public long getWin6Num() {
        return win6Num;
    }

    public Double getEarnRate() {
        return earnRate;
    }
}
