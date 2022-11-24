package programmers.level1;

import java.util.Arrays;

public class 로또의_최고_순위와_최저_순위 {

    public int[] solution(int[] lottos, int[] win_nums) {
        //lottos에서 0의 개수를 알아냄
        //0을 제외한 숫자 중 맞은 숫자가 몇개인지 알아냄
        //최고 : 맞은 숫자 + 0의 개수
        //최저 : 맞은 숫자

        int[] ranking = {6, 6, 5, 4, 3, 2, 1};

        int zero = 0;
        int match = 0;

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int i = 0;
        int j = 0;
        while(i < lottos.length && j < win_nums.length) {
            if(lottos[i] == 0) {
                zero++;
                i++;
            }
            else {
                if(lottos[i] == win_nums[j]) {
                    match++;
                    i++;
                    j++;
                }
                else if(lottos[i] < win_nums[j]) {
                    i++;
                }
                else {
                    j++;
                }
            }
        }

        final int max = zero + match;
        final int min = match;

        return new int[]{ranking[max], ranking[min]};
    }
}
