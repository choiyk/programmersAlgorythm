package javaCodingInterview.Chapter10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EncodedStringTest {

    @Test
    public void test() {
        EncodedString o = new EncodedString();
        String s = " abc   fg";
        char[] result = {'%','2','0','a','b','c','%','2','0','%','2','0','%','2','0','f','g'};
        assertEquals(Arrays.toString(o.solution(s)), Arrays.toString(result));
    }

}