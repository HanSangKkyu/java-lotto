import java.util.Map;

import domain.LottoGame;
import domain.Rank;
import view.InputView;
import view.ResultView;

public final class LottoMain {
    public static void main(String[] args) {
        final LottoGame lottoGame = new LottoGame();
        final int money = InputView.inputMoney();

        ResultView.printBuyLottoResult(lottoGame.buyLotto(money));

        final String wonLottoString = InputView.inputWonLottoNumbers();
        final int bonusNumber = InputView.inputBonusNumber();
        final Map<Rank, Long> lottoResult = lottoGame.checkWin(wonLottoString, bonusNumber);

        ResultView.printWonResult(lottoResult);
    }
}
