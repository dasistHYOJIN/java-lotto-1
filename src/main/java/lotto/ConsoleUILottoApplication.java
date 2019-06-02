package lotto;

import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ConsoleUILottoApplication {
    public static void main(String[] args) {
        int price = InputView.inputMoney();
        Money money = new Money(price);

        int amountOfCustoms = InputView.inputAmountOfCustom();
        LottoTickets lottoTickets = new LottoTickets(amountOfCustoms);
        InputView.printCustomLottoNumbersMessage();
        while(lottoTickets.needMoreCustomLottoTicket()) {
            lottoTickets.putCustomLottoTicket(InputView.inputLottoNumbers());
        }



        OutputView.printLottoTickets(amountOfCustoms, money.getTicketCount(), lottoTickets.getLottoTickets());

        InputView.printWinningLottoNumbersMessage();
        String winningLottoNumbers = InputView.inputLottoNumbers();
        int bonusBall = InputView.inputBonusBall();
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumbers, bonusBall);
    }
}
