package io.github.mangjoo.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallsTest {
    @Test
    void 리스트_생성_테스트() {
        List<Ball> balls = List.of(
                new Ball(1),
                new Ball(2),
                new Ball(3)
        );
        assertDoesNotThrow(() -> new Balls(balls));
    }

    @Test
    void 배열_생성_테스트() {
        //given
        int[] arrayBalls = {1, 2, 3};

        //then
        assertDoesNotThrow(() -> new Balls(arrayBalls));
    }

    @Test
    void 문자열_생성_테스트() {
        //given
        String strBalls = "123";

        //then
        assertDoesNotThrow(() -> new Balls(strBalls));
    }

    @Test
    void ball_객체가_3개가_아닐_경우_예외가_발생한다() {
        List<Ball> balls = List.of(
                new Ball(1),
                new Ball(2),
                new Ball(3),
                new Ball(4)
        );
        int[] arrayBalls = {1, 2, 3, 4};
        assertThatCode(() -> new Balls(balls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공은 3개만 가질 수 있습니다.");
        assertThatCode(() -> new Balls(arrayBalls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공은 3개만 가질 수 있습니다.");
    }

    @Test
    void 공이_겹칠_경우_예외가_발생한다() {
        List<Ball> balls = List.of(
                new Ball(1),
                new Ball(2),
                new Ball(2)
        );
        int[] arrayBalls = {1, 2, 2};
        assertThatCode(() -> new Balls(balls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공의 숫자는 겹칠 수 없습니다.");
        assertThatCode(() -> new Balls(arrayBalls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공의 숫자는 겹칠 수 없습니다.");
    }

    @Test
    void 공_가져오기_테스트() {
        List<Ball> balls = List.of(
                new Ball(1),
                new Ball(2),
                new Ball(3)
        );
        List<Ball> ballList = new Balls(balls).balls();
        assertEquals(ballList, balls);
    }
}
