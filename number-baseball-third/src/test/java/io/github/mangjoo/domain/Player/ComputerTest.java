package io.github.mangjoo.domain.Player;

import io.github.mangjoo.domain.BallGenerator;
import io.github.mangjoo.domain.Balls;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerTest {
    @Test
    void 문자열_생성_테스트() {
        //given
        String strBalls = "123";

        //then
        assertDoesNotThrow(() -> Player.Computer(strBalls));
    }

    @Test
    void 배열_생성_테스트() {
        //given
        int[] arrayBalls = new int[]{1, 2, 3};

        //then
        assertDoesNotThrow(() -> Player.Computer(arrayBalls));
    }

    @Test
    void 위임_생성_테스트() {
        //given
        BallGenerator ballGenerator = new BallGenerator();

        //then
        assertDoesNotThrow(() -> Player.Computer(ballGenerator));
    }

    @Test
    void 공_가져오기_테스트() {
        //given
        String inputBall = "123";

        //when
        Player computer = Player.Computer(inputBall);
        Balls balls = new Balls(inputBall);

        //then
        assertEquals(computer.balls(), balls);
    }
}
