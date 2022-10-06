package racingcar;

import java.util.List;
import racingcar.view.RacingInputView;
import racingcar.view.RacingResultView;

public class RacingCarApplication {
    public static void main(String[] args) {
        List<String> carNames = RacingInputView.getCarNames();
        int tryNums = RacingInputView.getTryNums();

        RacingGame racingGame = new RacingGame(tryNums, carNames);
        RacingRecord racingRecord = racingGame.racingStart();

        RacingResultView.printRoundRecord(racingRecord);
    }
}
