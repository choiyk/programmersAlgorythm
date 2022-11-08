package leetcode.two;

public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while(left <= right) {
            final int middle = left + ((right - left) / 2);

            final int result = guess(middle);

            if(result == 0) {
                return middle;
            }
            else if(result < 0) {
                //middle > pick
                //왼쪽 그룹에서 탐색
                right = middle - 1;
            }
            else{
                //middle < pick
                //오른쪽 그룹에서 탐색
                left = middle + 1;
            }
        }

        return -1;
    }

    int guess(int num) {
        return 0;
    }

}
