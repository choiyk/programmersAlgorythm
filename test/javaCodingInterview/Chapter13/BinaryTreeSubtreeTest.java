package javaCodingInterview.Chapter13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeSubtreeTest {

    @Test
    public void test() {
        /*    P:                     Q:
              40                     30
            /    \                  /  \
          30      10               20   90
         /  \    /  \             /
        20   90  70 80           6
       /
      6
        */
        int[] pArr = {40,30,10,20,90,70,80,6};
        int[] qArr = {30,20,90,6};
        BinaryTreeSubtree o = new BinaryTreeSubtree();

        assertEquals(o.solution(pArr, qArr), true);
        assertEquals(o.solution(qArr, pArr), false);
    }

}