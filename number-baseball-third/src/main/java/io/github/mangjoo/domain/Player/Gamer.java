package io.github.mangjoo.domain.Player;

import io.github.mangjoo.domain.Balls;

public record Gamer(
        Balls balls
) implements Player {

    public Gamer(String userInput) {
        this(new Balls(userInput));
    }


    @Override
    public Balls balls() {
        return balls;
    }
}
