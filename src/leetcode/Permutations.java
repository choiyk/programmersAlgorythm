package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        permute(answer, new ArrayList<>(), nums);
        return answer;
    }

    private void permute(List<List<Integer>> answer, List<Integer> list, int[] nums) {
        //종료 : 다 뽑았을 때
        //최종 결과에 list를 추가
        if(list.size() >= nums.length) {
            //list를 복사해서 새로운 참조값으로 만든 후 answer에 추가
            answer.add(new ArrayList<>(list));
            return;
        }

        //아직 뽑지 않은 것들 중에서 뽑기
        for(int i = 0; i < nums.length; i++) {
            //이미 뽑은거면 넘어감
            if(list.contains(nums[i])) continue;

            //숫자를 뽑음
            list.add(nums[i]);
            permute(answer, list, nums);

            //다음 반복문에서 숫자를 뽑을 때 list 상태를 유지하기 위해 마지막 원소를 지움
            list.remove(list.size() - 1);
        }
    }

}
