package racingcar.domain;

public class Car {
    private final CarName carName;
    private final CarPosition carPosition;

    private Car(final CarName carName, final CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static Car createAtStart(String rawCarName) {
        return new Car(new CarName(rawCarName), CarPosition.initialPosition());
    }

    public Car move() {
        return new Car(carName, carPosition.advance());
    }

    public boolean isSamePosition(Car other) {
        return carPosition == other.carPosition;
    }

    public String getName() {
        return carName.value();
    }

    public int getPosition() {
        return carPosition.value();
    }
}
