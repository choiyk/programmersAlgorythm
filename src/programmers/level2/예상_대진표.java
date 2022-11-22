package programmers.level2;

public class 예상_대진표 {

    public int solution(int n, int a, int b) {
        //짝수면 n-1번과 붙고, 홀수면 n+1번과 붙음
        //다음 라운드에서는 짝수면 n/2번호, 홀수면 (n+1)/2를 받음
        //받은 번호의 차이가 1이면 둘이 붙는 것

        int round = 1;

        while(true) {
            a = getNumber(a);
            b = getNumber(b);

            if(a == b)
                break;

            round++;
        }

        return round;
    }

    private int getNumber(int a) {
        if(a % 2 == 0)
            return a / 2;
        else
            return (a + 1) / 2;
    }
}
