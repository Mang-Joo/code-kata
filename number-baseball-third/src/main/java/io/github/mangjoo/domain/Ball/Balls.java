package io.github.mangjoo.domain.Ball;

import java.util.Arrays;
import java.util.List;

public record Balls(
        BallList balls
) {

    public Balls {
        validation(balls.toList());
    }

    private void validation(List<Ball> balls) {
        if (balls.size() != 3) {
            throw new IllegalArgumentException("공은 3개만 가질 수 있습니다.");
        }
        long reduplicationCount = balls.stream()
                .distinct()
                .count();
        if (reduplicationCount != 3) {
            throw new IllegalArgumentException("공의 숫자는 겹칠 수 없습니다.");
        }

    }

    public Balls(int[] arrayBalls) {
        this(new ArrayAsBallList(arrayBalls));
//        this(arrayToList(arrayBalls));
    }

    public Balls(String strBalls) {
        this(new StringAsBallList(strBalls));
    }

    private static List<Ball> stringToList(String strBalls) {
        return Arrays.stream(strBalls.split(""))
                .mapToInt(Integer::parseInt)
                .mapToObj(Ball::new)
                .toList();
    }

    private static List<Ball> arrayToList(int[] arrayBalls) {
        return Arrays.stream(arrayBalls)
                .mapToObj(Ball::new)
                .toList();
    }
}
