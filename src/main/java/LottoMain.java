public class LottoMain {
    public static void main(String[] args) {
        final int money = InputView.inputMoney();
        final LottoGame lottoGame = new LottoGame();
        ResultView.printBuyLottoResult(lottoGame.buyLotto(money));
        final String wonLottoString = InputView.inputWonLottoNumbers();
        final LottoResult lottoResult = lottoGame.checkWin(wonLottoString);
        ResultView.printWonResult(lottoResult);
    }
}
