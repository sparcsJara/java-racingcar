package racing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racing.Car.isMove;
import static racing.RacingGame.splitCarName;

public class CarTest {

    @Test
    void 랜덤값이_4이상이면_전진한다() {
        assertThat(isMove(4)).isTrue();
    }

    @Test
    void 랜덤값이_4미만이면_전진하지_못한다() {
        assertThat(isMove(3)).isFalse();
    }

    @Test
    void 랜덤값이_4이상이면_포지션값이_1_증가한다() {
        TestGenerateNumber generateNumber = new TestGenerateNumber(4);
        Car car = new Car("njw",1);
        car.move(generateNumber);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void 랜덤값이_4미만이면_포지션값이_그대로다() {
        TestGenerateNumber generateNumber = new TestGenerateNumber(3);
        Car car = new Car("njw",1);
        car.move(generateNumber);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차에_이름을_부여할_수_있다() {
        Car car = new Car("njw");
        assertThat(car.getName()).isEqualTo("njw");
    }

    @Test
    void 자동차_이름이_5글자_초과되면_에러가_발생한다() {
        assertThatThrownBy(() -> new Car("njwnjw"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름을_쉼표로_구분하여_입력받을_수_있다() {
        String[] carNames = splitCarName("njw,njw2,njw3");
        assertThat(carNames).containsExactly("njw", "njw2", "njw3");
    }

    @Test
    void 경기가_끝나면_우승한_자동차를_가져올_수_있다() {
        Car car1 = new Car("A", 3);
        Car car2 = new Car("B", 2);
        Car car3 = new Car("C", 1);
        Cars cars = new Cars(List.of(car1, car2, car3));

        String winners = cars.getWinner();

        assertThat(winners).isEqualTo("A");
    }

    @Test
    void 경기가_끝나면_우승한_자동차를_가져올_수_있다_여러명() {
        Car car1 = new Car("Q", 5);
        Car car2 = new Car("W", 2);
        Car car3 = new Car("E", 5);

        Cars cars = new Cars(List.of(car1, car2, car3));

        String winners = cars.getWinner();

        assertThat(winners).isEqualTo("Q,E");
    }

}