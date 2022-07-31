import java.util.Arrays;

public class MissingInteger {

    public int solution(int[] A) {
        if(A == null || A.length <= 0) return 1;
        Arrays.sort(A);
        if(A[A.length-1] <= 0 || A[0] > 1) return 1;
        for(int i=0; i<A.length-1; i++) {
            if(A[i] < 0 || A[i] == A[i+1] || A[i] + 1 == A[i+1]) continue;
            return A[i] + 1;
        }
        int answer =  A[A.length-1] + 1;
        if(answer > 1000000) return 1;
        return answer;
    }

    public static void main(String[] args) {
        int[] A = new int[]{-1000000, 1000000};
        MissingInteger o = new MissingInteger();
        System.out.println(o.solution(A));
    }
}
