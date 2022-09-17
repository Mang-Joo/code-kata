package io.github.mangjoo.domain.Player;

import io.github.mangjoo.domain.Balls;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamerTest {
    @Test
    void 생성_테스트() {
        //given
        String inputBall = "123";

        //then
        assertDoesNotThrow(() -> Player.Gamer(inputBall));
    }

    @Test
    void 공_가져오기_테스트() {
        //given
        String inputBall = "123";

        //when
        Player gamer = Player.Gamer(inputBall);
        Balls balls = new Balls(inputBall);

        //then
        assertEquals(gamer.balls(), balls);
    }
}
