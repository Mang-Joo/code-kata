package io.github.mangjoo.domain.Ball;

import java.util.Arrays;
import java.util.List;

public record StringAsBallList(
        String numbers
) implements BallList {
    @Override
    public List<Ball> toList() {
        return Arrays.stream(numbers.split(""))
                .mapToInt(Integer::parseInt)
                .mapToObj(Ball::new)
                .toList();
    }
}
