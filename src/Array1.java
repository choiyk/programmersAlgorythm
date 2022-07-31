import java.util.Arrays;

public class Array1 {

    public int[] solution(int[] A, int K) {
        for(int j = 0; j < K ; j++){
            int last = A[A.length-1];
            for(int i = A.length-1; i>0; i--){
                A[i] = A[i-1];
            }
            A[0] = last;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        int K = 4;
        Array1 o = new Array1();
        System.out.println(Arrays.toString(o.solution(A, K)));
    }
}
