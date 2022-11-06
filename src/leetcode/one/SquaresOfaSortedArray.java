package leetcode.one;

public class SquaresOfaSortedArray {

    public int[] sortedSquares(int[] nums) {
        //nums를 제곱한다.
        for(int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        //정렬
        selectSort(nums);

        return nums;
    }

    public void selectSort(int[] nums) {
        //선택 정렬 : O(N^2)

        for(int i = 0; i < nums.length - 1; i++) {
            int min = nums[i];

            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < min) {
                    //값을 바꿈
                    nums[i] = nums[j];
                    nums[j] = min;

                    min = nums[i];
                }
            }
        }
    }

    public void insertSort(int[] nums) {
        //삽입 정렬 : O(N^2)

        for(int i = 1; i < nums.length; i++) {
            int min = nums[i];

            //i보다 앞선 숫자들 중에 더 작은 값이 있으면 뒤로 땡기고 그 자리에 값을 넣는다.
            int j = i - 1;
            while(j >= 0 && nums[j] > min) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = min;
        }
    }

    public void mergeSort(int[] nums) {
        //병합 정렬 : O(NlogN)

        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int startIdx, int endIdx) {
        //정렬할 값이 하나 뿐이면 정렬할 필요가 없음
        if(startIdx == endIdx)
            return;

        //반으로 나눈다.
        final int middleIdx = (startIdx + endIdx) / 2;

        final int g1StartIdx = startIdx;
        final int g1EndIdx = middleIdx;
        final int g2StartIdx = middleIdx + 1;
        final int g2EndIdx = endIdx;

        //각각 재귀호출로 정렬한다.
        mergeSort(nums, g1StartIdx, g1EndIdx);
        mergeSort(nums, g2StartIdx, g2EndIdx);

        //두 그룹을 앞에서부터 비교해 더 작은 값부터 뽑는다.
        int[] temp = new int[(endIdx - startIdx) + 1];//정렬된 값을 저장할 임시 배열
        int p1 = g1StartIdx;
        int p2 = g2StartIdx;
        int idx = 0; //temp의 index

        while(p1 <= g1EndIdx && p2 <= g2EndIdx) {
            if(nums[p1] < nums[p2]) {
                temp[idx++] = nums[p1++];
            }
            else {
                temp[idx++] = nums[p2++];
            }
        }

        //뽑히지 못하고 아직 남은 값을 temp에 넣는다.
        while(p1 <= g1EndIdx) {
            temp[idx++] = nums[p1++];
        }

        while(p2 <= g2EndIdx) {
            temp[idx++] = nums[p2++];
        }

        //nums 배열 정리
        for(int i = 0; i < temp.length; i++) {
            nums[startIdx + i] = temp[i];
        }
    }

    public void quickSort(int[] nums) {
        //퀵 소트 : O(NlogN), 최악 O(N^2)
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int startIdx, int endIdx) {
        //정렬할 값이 하나뿐이면 정렬할 필요가 없음
        if(startIdx >= endIdx)
            return;

        //비교의 기준값 = endIdx
        final int pivot = nums[endIdx];
        int idx = startIdx;

        //기준값보다 작은 값은 왼쪽에 큰 값은 오른쪽에
        int i = startIdx;
        for(int j = startIdx; j < endIdx; j++) {
            if(nums[j] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        }

        //기준값을 가운데로
        int temp = nums[i];
        nums[i] = nums[endIdx];
        nums[endIdx] = temp;

        //작은 값 그룹을 정렬
        quickSort(nums, startIdx, i - 1);

        //큰 값 그룹을 정렬
        quickSort(nums, i + 1, endIdx);
    }
}
