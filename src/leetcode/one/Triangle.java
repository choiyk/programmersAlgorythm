package leetcode.one;

import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        final int m = triangle.size();
        final int n = triangle.get(m - 1).size();
        int[][] cached = new int[m][n];

        //마지막 줄 캐시
        final List<Integer> lastList = triangle.get(m - 1);
        for(int i = 0; i < lastList.size(); i++) {
            cached[m - 1][i] = lastList.get(i);
        }

        //밑에서부터 올라오는데
        for(int i = m - 2; i >= 0; i--) {
            final List<Integer> list = triangle.get(i);

            for(int j = 0; j < list.size(); j++) {
                final int p0 = list.get(j);

                //아랫줄의 idx와 idx+1의 값 중 비교해서 더 작은 값을 캐시
                final int p1 = cached[i + 1][j];
                final int p2 = cached[i + 1][j + 1];

                cached[i][j] = p0 + (p1 < p2 ? p1 : p2);
            }
        }

        //최종 triangle[0][0] 리턴
        return cached[0][0];
    }

}
