package javaCodingInterview.Chapter8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicIndexTest {

    @Test
    public void test() {
        int[] arr = {-5,-4,-2,0,1,2,3,5,6,7,9,11,13};
        int[] arr2 = {1,4,4,4,5,5,6,6,6,11,12,12,12,15,17,20,21,21};
        MagicIndex o = new MagicIndex();
        //System.out.println(o.solution(arr));
        System.out.println(o.solution(arr2));
    }

}