package step3;

import step3.view.InputView;

public class CarRaceApplication {
    public static void main(String[] args) {
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        int carNumbers = InputView.inputNumberOfCars();
        int numberOfAttempts = InputView.inputNumberOfAttempts();
        System.out.println("실행 결과");

        CarRacingController controller = new CarRacingController(carNumbers, randomMoveStrategy);
        controller.racingStart(numberOfAttempts);
    }
}
