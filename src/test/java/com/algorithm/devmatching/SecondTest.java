package com.algorithm.devmatching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SecondTest {
    Second second = new Second();

    @Test
    public void Test() {
        //given
        int leave = 4;
        String day = "FRI";
        int[] holidays = {6, 21, 23, 27, 28};
        int expect = 10;


        //when
        int result = second.solution(leave, day, holidays);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}