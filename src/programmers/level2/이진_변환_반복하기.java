package programmers.level2;

public class 이진_변환_반복하기 {

    int removeCnt = 0;

    public int[] solution(String s) {
        String res = new String(s);
        int doCnt = 0;

        while(!res.equals("1")) {
            res = compute(res);

            doCnt++;
        }

        return new int[]{doCnt, removeCnt};
    }

    private String compute(String s) {
        //1인 bit 수 세기
        //1의 개수를 이진 문자열로 변환하여 반환
        //제거한 0의 개수 반영

        char[] chars = s.toCharArray();
        int falseCnt = 0;

        for(char c : chars) {
            if(c == '0')
                falseCnt++;
        }

        int trueCnt = s.length() - falseCnt;

        removeCnt += falseCnt;

        return Integer.toBinaryString(trueCnt);
    }
}
