package javaCodingInterview.Chapter10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueCharactersTest {

    @Test
    public void test() {
        String s1 = "a b c";
        String s2 = "a b b b c a";
        UniqueCharacters o = new UniqueCharacters();
        assertEquals(o.solution(s1), true);
        assertEquals(o.solution(s2), false);
    }

}