package step3.ui;

import step3.Racing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final int MINIMUM_NUMBER = 0;

    public static InputRequest createInputRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = createIntNumber(scanner);
        System.out.println("시도할 횟수는 몇 회 인가여?");
        int tryNumber = createIntNumber(scanner);
        return new InputRequest(carNumber, tryNumber);
    }

    private static int createIntNumber(Scanner scanner) {
        try {
            int carNumber = scanner.nextInt();
            if (carNumber < MINIMUM_NUMBER) {
                throw new InputMismatchException();
            }
            return carNumber;
        } catch (InputMismatchException exception) {
            throw new InputMismatchException("양수의 숫자만 입력해주세요");
        }
    }
}
