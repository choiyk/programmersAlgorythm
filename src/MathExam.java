import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MathExam {

    public static int[] solution(int[] answers) {
        int[] howManyCorrect = {0,0,0};

        int[][] hows = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        for(int i=0; i<hows.length; i++){
            for(int j=0; j<answers.length; j++){
                int how = j % hows[i].length;
                if(answers[j] == hows[i][how]) {
                    howManyCorrect[i]++;
                }
            }
        }

        Stack<Integer> whoBest = new Stack<>();
        int max = Arrays.stream(howManyCorrect).max().getAsInt();
        for(int i=0; i<3; i++){
            if(howManyCorrect[i] == max) {
                whoBest.push(i+1);
            }
        }

        int[] answer = new int[whoBest.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = whoBest.pop();
        }
        Arrays.sort(answer);

        return answer;
    }

    public static int[] solution2(int[] answers) {
        int[] howManyCorrect = {0,0,0};
        int[] how1 = {1, 2, 3, 4, 5};
        int[] how2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] how3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i=0; i<answers.length; i++){
            if(answers[i] == how1[i % how1.length]) {howManyCorrect[0]++;}
            if(answers[i] == how2[i % how2.length]) {howManyCorrect[1]++;}
            if(answers[i] == how3[i % how3.length]) {howManyCorrect[2]++;}
        }

        int max = Arrays.stream(howManyCorrect).max().getAsInt();

        Stack<Integer> whoBest = new Stack<>();
        if(howManyCorrect[2] == max) {whoBest.push(3);}
        if(howManyCorrect[1] == max) {whoBest.push(2);}
        if(howManyCorrect[0] == max) {whoBest.push(1);}

        int[] answer = new int[whoBest.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = whoBest.pop();
        }

        //ArrayList로 결과 만들기
        ArrayList<Integer> whoBestList = new ArrayList<>();
        if(howManyCorrect[0] == max) {whoBestList.add(1);}
        if(howManyCorrect[1] == max) {whoBestList.add(2);}
        if(howManyCorrect[2] == max) {whoBestList.add(3);}
        int[] result = whoBestList.stream().mapToInt(i -> i.intValue()).toArray();

        return answer;
    }

    public static void main(String[] args) {
        //int[] answer = {1,3,2,4,2};
        int[] answer = {1,2,3,4,5};
        System.out.println(Arrays.toString(solution2(answer)));
    }

}
