package io.github.mangjoo.domain.Player;

import io.github.mangjoo.domain.Balls;
import io.github.mangjoo.domain.MakeRandomBall;

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

    static Player Computer(MakeRandomBall makeRandomBall) {
        return new Computer(makeRandomBall);
    }

    Balls balls();


    static Player Gamer(String userInput) {
        return new Gamer(userInput);
    }
}
