package domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        assertionPositiveNumber(value);
        this.value = value;
    }

    private void assertionPositiveNumber(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치는 음수를 가질 수 없습니다.");
        }
    }

    public int getValue() {
        return this.value;
    }

    public void moveForward() {
        this.value++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Position p) {
        return Integer.compare(this.value, p.getValue());
    }
}