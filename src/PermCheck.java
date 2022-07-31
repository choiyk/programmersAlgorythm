import java.util.ArrayList;
import java.util.Arrays;

public class PermCheck {

    public int solution(int[] A) {
        Arrays.sort(A);
        if(A.length != A[A.length-1]) return 0;
        for(int i = 0; i<A.length-1; i++){
            if(A[i] + 1 != A[i+1]) return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2};
        PermCheck o = new PermCheck();
        System.out.println(o.solution(A));
    }
}
