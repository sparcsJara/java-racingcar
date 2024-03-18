# [미션1] 자동차 경주 - 단위테스트
> kylekim2123, 김영주

<br>

## [STEP 2] 문자열 덧셈 계산기
1. **입력된 문자열에서 쉼표(,) 혹은 콜론(:)을 구분자로 사용하여 분리 한 후 각 숫자의 합을 반환한다.**
    - 예) `1,2` 와 같이 입력할 경우, 3을 반환한다.
    - 예) `3:4` 와 같이 입력할 경우, 7을 반환한다.
    - 예) `1,2:3` 와 같이 입력할 경우 6을 반환한다.
2. **쉼표(,) 혹은 콜론(:) 이외의 커스텀 구분자를 지정할 수 있다.**
    - 문자열 앞부분에서, `//` 와 `\n` 사이에 커스텀 구분자를 위치시켜 지정할 수 있다.
    - 예) `//;\n1;2;3` 와 같이 입력할 경우, 세미콜론(;)을 구분자로 하여 6을 반환한다.
3. **아래와 같은 상황에서는 RuntimeException을 던진다.**
    - 피연산자가 숫자 이외의 값인 경우
    - 피연산자가 음수인 경우
4. **기타 상황에 관해서는 아래와 같이 처리한다.**
    - 입력된 문자열이 빈 문자열이거나 null 인 경우에는 0을 반환한다.
    - 입력된 문자열이 단 한 개의 숫자인 경우에는 해당 숫자를 그대로 반환한다.
    - 입력된 문자열이 빈 문자열 뿐만 아니라, 공백이거나 개행의 경우에도 0을 반환하도록 한다. 
    - 피연산자가 Long 타입의 범위를 넘어서는 큰 수이더라도 계산을 지원한다.

<br>

---

## [STEP 3] 자동차 경주
1. 사용자는 자동차 대수를 입력할 수 있다.
   - [x]  자동차 대수를 입력받는다.
   - [x]  자동차 대수가 정수 형태가 아닌 경우 예외를 던진다.
   - [x]  자동차 대수가 0이하의 숫자인 경우 예외를 던진다.
2. 사용자는 시도 횟수를 입력할 수 있다.
   - [x]  시도 횟수를 입력받는다.
   - [x]  시도 횟수가 정수 형태가 아닌 경우 예외를 던진다.
   - [x]  시도 횟수가 0이하의 숫자인 경우 예외를 던진다.
3. 매 시도마다 각 자동차는 0에서 9사이의 난수를 받아, 전진하거나 전진하지 않는다.
   - [x]  0에서 9사이의 난수를 생성한다.
   - [x]  난수가 0이상 3이하인 경우, 자동차는 전진하지 않는다.
   - [x]  난수가 4이상 9이하인 경우, 자동차는 전진한다.
4. 사용자는 자동차 경주의 과정을 볼 수 있다.
   - [x]  자동차 경주의 과정을 출력한다.

<br>

---

## [STEP 4] 자동차 경주 (우승자)
1. **사용자는 자동차 이름 목록을 입력할 수 있다.**
   - 정상
      - [x]  특정 구분자를 기준으로 입력 문자열을 구분하여 자동차 이름 목록을 생성한다.
      - [x]  자동차 이름은 한 글자 이상의 공백이 없는 영어 소문자와 숫자로 입력받는다.
      - [x]  입력 받은 자동차 이름의 양쪽 끝에 공백이 있는 경우 제거한다.
   - 예외
      - [x]  입력 문자열 자체가 빈문자열, 공백, 개행인 경우 예외를 던진다.
      - [x]  자동차 이름 목록에 중복이 존재하는 경우 예외를 던진다.
      - [x]  자동차 이름에 (영어 소문자나 숫자) 이외의 문자가 포함된 경우 예외를 던진다.
      - [x]  자동차 이름이 빈 문자열, 공백, 개행인 경우 예외를 던진다.
      - [x]  자동차 이름이 최대 길이(5 글자)를 초과하는 경우 예외를 던진다.
2. **사용자는 시도 횟수를 입력할 수 있다.**
   - 정상
      - [x]  시도 횟수는 1 이상의 정수로 입력받는다.
   - 예외
      - [x]  시도 횟수가 정수 형태가 아닌 경우 예외를 던진다.
      - [x]  시도 횟수가 0 이하인 경우 예외를 던진다.
3. **매 라운드마다 임의의 조건수를 생성하고, 조건수에 따라 자동차는 전진하거나 현재 위치를 유지한다.**
   - 정상
      - [x]  임의의 조건수(0이상 9이하의 난수)를 생성한다.
      - [x]  조건수가 전진 범위(0이상 3이하)에 해당하는 경우, 자동차는 전진한다.
      - [x]  조건수가 현재 위치 유지 범위(4이상 9이하)에 해당하는 경우, 자동차는 현재 위치를 유지한다.
   - 예외
      - [x]  조건수가 전진 범위에도, 현재 위치 유지 범위에도 해당하지 않으면 예외를 던진다.
4. **사용자는 자동차 경주의 과정과 결과를 볼 수 있다.**
5. **사용자는 자동차 경주의 우승자를 알 수 있다.**
   - 정상
      - [x]  레이스를 진행한 자동차들 중, 가장 많이 전진한 자동차가 우승한다.
      - [x]  가장 많이 전진한 자동차가 여러 대인 경우, 우승자는 여러 명이 된다.
