import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KthNumber {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int r=0; r<commands.length; r++){
            int i = commands[r][0];
            int j = commands[r][1];
            int k = commands[r][2];

            int[] sliceArr = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(sliceArr);
            answer[r] = sliceArr[k-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(solution(array, commands).toString());
    }

}
