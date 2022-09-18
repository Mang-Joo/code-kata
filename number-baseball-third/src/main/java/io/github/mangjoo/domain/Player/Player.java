package io.github.mangjoo.domain.Player;

import io.github.mangjoo.domain.BallGenerator;
import io.github.mangjoo.domain.Balls;

import java.util.Arrays;

public interface Player {
    static Player Computer(String strBalls) {
        int[] arrayBalls = Arrays.stream(strBalls.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        return Player.Computer(arrayBalls);
    }

    static Player Computer(int[] ballNumbers) {
        return new Computer(ballNumbers);
    }

    static Player Computer(BallGenerator ballGenerator) {
        return new Computer(ballGenerator);
    }

    Balls balls();


    static Player Gamer(String userInput) {
        return new Gamer(userInput);
    }
}
