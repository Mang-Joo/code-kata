package io.github.mangjoo.domain.Player;

import io.github.mangjoo.domain.Ball;
import io.github.mangjoo.domain.BallGenerator;
import io.github.mangjoo.domain.Balls;

import java.util.Arrays;
import java.util.List;

public record Computer(
        Balls balls
) implements Player {

    public Computer(int[] arrayBallNumbers) {
        this(arrayBallsToListBalls(arrayBallNumbers));
    }

    public Computer(BallGenerator ballGenerator) {
        this(ballGenerator.makeRandom());
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
