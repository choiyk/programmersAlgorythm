import java.util.Arrays;
import java.util.HashMap;

public class Array2 {
    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<A.length; i++){
            if(map.containsKey(A[i])) {
                map.remove(A[i]);
            }
            else{
                map.put(A[i], i);
            }
        }

        return map.keySet().toArray(new Integer[map.keySet().size()])[0];
    }

    public static void main(String[] args) {
        int[] A = new int[]{9,3,9,3,9,7,9};
        Array2 o = new Array2();
        System.out.println(o.solution(A));
    }
}
