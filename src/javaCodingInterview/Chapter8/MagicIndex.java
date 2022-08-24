package javaCodingInterview.Chapter8;

public class MagicIndex {

    public int solution(int[] arr) {
        return compute(arr, 0, arr.length-1);
    }

    private int compute(int[] arr, int start, int end) {
        int val;
        if(start > end) return -1;

        int middle = (start + end) / 2;
        if((val = arr[middle]) == middle) return middle;    //magic index

        int find = compute(arr, start, Math.min(middle-1, val));   //왼쪽에서 찾기
        if(find >= 0) return find;
        else return compute(arr, Math.max(middle+1, val), end);  //오른쪽에서 찾기
    }
}
