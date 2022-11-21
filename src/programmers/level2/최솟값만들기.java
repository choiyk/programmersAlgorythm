package programmers.level2;

import java.util.Arrays;

public class 최솟값만들기 {

    public int solution(int []A, int []B)
    {
        //두 배열을 정렬
        //가장 작은 값과 가장 큰 값을 곱해나감
        //각 결과를 누적

        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        int j = B.length - 1;

        while(i < A.length && j >= 0) {
            answer += A[i++] * B[j--];
        }

        return answer;
    }

}
