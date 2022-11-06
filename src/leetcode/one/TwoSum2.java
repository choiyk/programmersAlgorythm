package leetcode.one;

public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];

        //O(n^2)
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) {
                    answer[0] = i + 1;
                    answer[1] = j + 1;
                    break;
                }
            }
        }

        return answer;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int[] answer = new int[2]; //답을 저장할 변수

        int leftIdx = 0; //왼쪽 인덱스
        int rigthIdx = numbers.length - 1; //오른쪽 인덱스

        while(leftIdx < rigthIdx) {
            int sum = numbers[leftIdx] + numbers[rigthIdx];

            if(sum == target) {
                answer[0] = leftIdx + 1;
                answer[1] = rigthIdx + 1;
                break;
            }

            //sum이 target보다 크다면 숫자를 줄여야 함
            //numbers는 정렬되어 있기 때문에 오른쪽 index를 하나 줄인다.
            if(sum > target) {
                rigthIdx--;
            }
            //반대로 target보다 작으면 숫자를 키워야 함
            //왼쪽 index를 하나 키운다.
            else {
                leftIdx++;
            }
        }

        return answer;
    }

}
