package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    @Test
    @DisplayName("생성되면 초기 상태 wrapResult만 가집니다.")
    void initializedWrapResultsSizeTest() {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        CarRacing racing = CarRacing.valueOf(carNames);
        assertThat(racing.getWrapResults().getWrapResults().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("생성되면 차 이름에 해당하는 차를 모두 가지고 있습니다.")
    public void racingCarsTest() {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        CarRacing racing = CarRacing.valueOf(carNames);
        List<RacingCar> racingCars = racing.getRacingCars();
        carNames.forEach(carName -> assertThat(racingCars)
                .filteredOn(racingCar -> racingCar.getName().equals(carName))
                .isNotEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,5,7,9})
    @DisplayName("proceedWraps을 진행하면 wrapResult가 tryNumber + 1만큼 생깁니다 ")
    public void proceedWrapsTest(int tryNumber) {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        CarRacing racing = CarRacing.valueOf(carNames);
        racing.proceedWraps(tryNumber);
        int afterRacingWrapResultsSize = racing.getWrapResults().getWrapResults().size();
        assertThat(afterRacingWrapResultsSize).isEqualTo(tryNumber + 1);
    }
}
