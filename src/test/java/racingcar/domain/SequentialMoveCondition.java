package racingcar.domain;

import java.util.*;

public class SequentialMoveCondition implements MoveCondition {
    private final Queue<Boolean> moveSequence;

    public SequentialMoveCondition(Boolean... sequence) {
        this.moveSequence = new LinkedList<>(Arrays.asList(sequence));
    }

    @Override
    public boolean canMove() {
        if (moveSequence.isEmpty()) {
            throw new IllegalStateException("더 이상 정의된 이동 시퀀스가 없습니다.");
        }
        return moveSequence.poll();
    }
}
