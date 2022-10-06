package racingcar.step3_4.domain;

import java.util.Random;
import racingcar.step3_4.view.ResultView;

public class Game {

	private static final Random random = new Random();
	private static final int LIMIT = 10;
	private static final RandomValueGenerator randomValueGenerator = () -> random.nextInt(LIMIT);

	private final ResultView resultView;

	public Game(ResultView resultView) {
		this.resultView = resultView;
	}

	public void play(GameAttribute gameAttribute) {
		Names names = Names.of(gameAttribute.getCarNames());
		Cars cars = Cars.createCars(names);
		for (int i = 0; i < gameAttribute.getTryCount(); i++) {
			cars.move(randomValueGenerator);
			resultView.printEachTryResult(cars.getCars());
		}
		resultView.printWinners(cars.determineWinners());
	}
}