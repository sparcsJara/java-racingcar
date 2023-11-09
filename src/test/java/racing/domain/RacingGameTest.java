package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private final String userNameAnswer = "a,b,c";

    // 무조건 전진하는 이동전략
    private final TestMoveStrategy testMoveStrategy = new TestMoveStrategy(new Random());


    @DisplayName("횟수와 자동차 대수를 입력받아 레이싱 게임을 생성한다. 자동차는 게임을 수행하면 전진한다.")
    @Test
    void create_racing_success() {
        // given
        int carCount = 3;
        int gameCount = 1;

        // when
        RacingGame racingGame = new RacingGame(userNameAnswer, carCount, gameCount, testMoveStrategy);

        // then
        racingGame.doRacing();

        assertThat(racingGame.getGameCount()).isEqualTo(1);
        assertThat(racingGame.getRacingCars()).extracting("position").containsOnly(1);
    }

    @DisplayName("생성된 레이싱 게임의 초기 자동차 이동거리는 0 이다.")
    @Test
    void first_car_position_is_zero_success() {
        // given
        int carCount = 3;
        int gameCount = 1;

        // when
        RacingGame racingGame = new RacingGame(userNameAnswer, carCount, gameCount, testMoveStrategy);

        // then
        assertThat(racingGame.getGameCount()).isEqualTo(1);
        assertThat(racingGame.getRacingCars()).extracting("position")
                .containsOnly(0);
    }

    @DisplayName("입력받은 자동차 대수만큼 자동차를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void create_car_by_input_success(int input) {
        // given
        String userNameAnswer = "a,b,c,d,e";
        RacingGame racingGame = new RacingGame(userNameAnswer, input, 5, testMoveStrategy);

        // when
        List<Car> racingCarList = racingGame.getRacingCars();

        // then
        assertThat(racingCarList).hasSize(input);
    }

    @DisplayName("설정한 게임횟수만큼 게임을 수행한다.")
    @Test
    void do_race_success() {
        // given
        CarMoveStrategy carMoveStrategy = new CarMoveStrategy(new Random(), 3);
        RacingGame racingGame = new RacingGame(userNameAnswer, 3, 5, carMoveStrategy);

        // when
        racingGame.doRacing();

        // then
        assertThat(racingGame.getRacingCars()).hasSize(3)
                .extracting(Car::getPosition)
                .containsExactly(0, 0, 0);
    }

    @DisplayName("자동차 이름을 포함하여 레이싱 게임을 생성한다. 생성한 게임 내 차들은 각각의 이름을 갖는다.")
    @Test
    void create_racing_game_with_user_name() {
        // given
        final String userNameAnswer = "김동규,박동규,최동규";
        final int carCount = 3;
        final int gameCount = 1;

        // when
        RacingGame racingGame = new RacingGame(userNameAnswer, carCount, gameCount, testMoveStrategy);

        // then
        assertThat(racingGame).isNotNull();
        assertThat(racingGame.getRacingCars())
                .extracting("carName")
                .containsExactly("김동규", "박동규", "최동규");
    }


    static class TestMoveStrategy extends CarMoveStrategy {
        public TestMoveStrategy(Random random) {
            super(random);
        }

        @Override
        public int getResult() {
            return 5;
        }
    }
}