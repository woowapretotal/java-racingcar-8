package racingcar.domain;

public class AlwaysMoveCondition implements MoveCondition {

    @Override
    public boolean canMove() {
        return true;
    }
}
