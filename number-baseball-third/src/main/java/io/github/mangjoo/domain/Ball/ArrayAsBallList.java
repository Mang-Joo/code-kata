package io.github.mangjoo.domain.Ball;

import java.util.Arrays;

public record ArrayAsBallList(
        int[] numbers
) implements BallList {
    @Override
    public java.util.List<Ball> toList() {
        return Arrays.stream(numbers)
                .mapToObj(Ball::new)
                .toList();
    }
}
