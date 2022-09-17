package io.github.mangjoo.domain;

public record Ball(
        int ball
) {

    public Ball {
        validation(ball);
    }

    public Ball(String strBall) {
        this(Integer.parseInt(strBall));
    }

    private void validation(int ball) {
        if (ball < 1 || ball > 9) {
            throw new IllegalArgumentException("숫자는 1~9까지만 사용할 수 있습니다.");
        }
    }
}
