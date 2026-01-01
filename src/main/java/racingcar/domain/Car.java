package racingcar.domain;

public class Car {
    private final CarName carName;
    private CarPosition carPosition;

    private Car(final CarName carName, final CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static Car createAtStart(CarName carName) {
        return new Car(carName, CarPosition.initialPosition());
    }

    public void move() {
        carPosition = carPosition.advance();
    }

    public String getName() {
        return carName.value();
    }

    public int getPosition() {
        return carPosition.value();
    }
}
