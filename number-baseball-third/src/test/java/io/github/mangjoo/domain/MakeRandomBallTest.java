package io.github.mangjoo.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MakeRandomBallTest {
    @Test
    void 생성_테스트() {
        //given
        assertDoesNotThrow(() -> new MakeRandomBall());

    }

    @Test
    @DisplayName("랜덤 볼 생성 테스트")
    void makeRandomBall() {
        //given
        MakeRandomBall makeRandomBall = new MakeRandomBall();

        //when
        int[] arrayNumbers = makeRandomBall.makeRandom();

        //then
        assertEquals(arrayNumbers.length, 3);

    }

}