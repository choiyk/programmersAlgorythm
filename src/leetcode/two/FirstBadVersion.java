package leetcode.two;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int startIdx = 1;
        int endIdx = n;

        while(startIdx <= endIdx) {
            final int middleIdx = startIdx + ((endIdx - startIdx) / 2);

            //true이면 하위 그룹 검색
            if(isBadVersion(middleIdx)) {
                endIdx = middleIdx - 1;; //end는 true
            }
            else { //false면 상위 그룹 검색
                startIdx = middleIdx + 1; //start는 false의 다음
            }
        }

        return startIdx;
    }

    private boolean isBadVersion(int version) {
        return true;
    }

}
