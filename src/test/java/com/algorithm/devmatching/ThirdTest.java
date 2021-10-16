package com.algorithm.devmatching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ThirdTest {
    Third third = new Third();

    @Test
    public void Test() {
        //given
        int[][] macaron = {{1, 1}, {2, 1}, {1, 2}, {3, 3}, {6, 4}, {3, 1}, {3, 3}, {3, 3}, {3, 4}, {2, 1}};

        String[] expect = {"000000", "000000", "000000", "000000", "000000", "204004"};

        //when
        String[] result = third.solution(macaron);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}