package leetcode;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int startIdx = 1;
        int endIdx = n;
        int result = 1;

        while(startIdx <= endIdx) {
            final int middleIdx = (startIdx + (endIdx - startIdx)) / 2;

            boolean _isBadVersion = isBadVersion(middleIdx);

            if(_isBadVersion) {
                endIdx = middleIdx - 1;
                result = middleIdx;
            }
            else
                startIdx = middleIdx + 1;
        }

        return result;
    }

    public boolean isBadVersion(int n) {
        return true;
    }

}
