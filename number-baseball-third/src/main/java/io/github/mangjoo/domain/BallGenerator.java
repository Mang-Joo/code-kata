package io.github.mangjoo.domain;

import java.util.random.RandomGenerator;

public record BallGenerator() {
    public int[] makeRandom() {
        return RandomGenerator.getDefault()
                .longs(1, 10)
                .limit(3)
                .boxed()
                .mapToInt(Long::intValue)
                .toArray();
    }
}
