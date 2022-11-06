package leetcode.one;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>(); //최종 결과
        combine(answer, new ArrayList<>(), n, k, 1);
        return answer;
    }

    private void combine(List<List<Integer>> answer, List<Integer> list, int n, int k, int start) {
        //종료 : k만큼 숫자를 뽑았을 때
        if(list.size() >= k) {
            answer.add(new ArrayList<>(list));
            return;
        }

        //종료 : 시작 숫자가 n보다 클 때
        if(start > n)
            return;

        for(int i = start; i <= n; i++) {
            //숫자 하나를 뽑고
            list.add(i);

            //나머지 재귀
            combine(answer, list, n, k, i + 1);

            //다음 반복문을 위해 뽑았던 값 돌려놓기
            list.remove(list.size() - 1);
        }
    }

}
