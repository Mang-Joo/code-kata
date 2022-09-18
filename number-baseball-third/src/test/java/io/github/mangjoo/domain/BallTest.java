package io.github.mangjoo.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BallTest {
    @Test
    void 생성_테스트() {
        assertDoesNotThrow(() -> new Ball(1));
    }

    @Test
    void 숫자가_들어오지_않을_경우_숫자로_변환한다() {
        assertDoesNotThrow(() -> new Ball("1"));
    }

    @Test
    void _1부터_9사이의_숫자가_아닐_경우_예외가_발생한다() {
        assertThatCode(() -> new Ball(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 1~9까지만 사용할 수 있습니다.");
        assertThatCode(() -> new Ball(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 1~9까지만 사용할 수 있습니다.");
        assertThatCode(() -> new Ball("10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 1~9까지만 사용할 수 있습니다.");
    }
}
