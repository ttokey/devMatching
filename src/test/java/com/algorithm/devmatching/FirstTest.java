package com.algorithm.devmatching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FirstTest {
    First first = new First();

    @Test
    public void Test() {
        //given
        String[] input = {"card", "ace13", "ace16", "banker", "ace17", "ace14"};
        String input2 = "ace15";
        String expect = "ace15";

        //when
        String result = first.solution(input, input2);

        //then
        Assertions.assertThat(result).isEqualTo(expect);


    }

}