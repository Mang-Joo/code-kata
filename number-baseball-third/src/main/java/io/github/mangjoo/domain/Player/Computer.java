package io.github.mangjoo.domain.Player;

import io.github.mangjoo.domain.Ball;
import io.github.mangjoo.domain.Balls;
import io.github.mangjoo.domain.MakeRandomBall;

import java.util.Arrays;
import java.util.List;

public record Computer(
        Balls balls
) implements Player {

    public Computer(int[] arrayBallNumbers) {
        this(arrayBallsToListBalls(arrayBallNumbers));
    }

    public Computer(MakeRandomBall makeRandomBall) {
        this(makeRandomBall.makeRandom());
    }

    private static Balls arrayBallsToListBalls(int[] arrayBallNumbers) {
        List<Ball> computerBall = Arrays.stream(arrayBallNumbers)
                .mapToObj(Ball::new)
                .toList();
        return new Balls(computerBall);
    }

    @Override
    public Balls balls() {
        return balls;
    }
}
