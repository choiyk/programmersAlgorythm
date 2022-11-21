package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 최대값과최솟값 {

    public String solution(String s) {
        //공백을 기준으로 문자열을 나눈다.
        //문자열을 숫자로 변환해 리스트를 만든다.
        //리스트를 정렬
        //맨 첫번째 값과 마지막 값을 조합하여 반환

        String[] strArr = s.split(" ");
        int[] numArr = new int[strArr.length];

        for(int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(numArr);

        return numArr[0] + " " + numArr[numArr.length - 1];
    }

}
