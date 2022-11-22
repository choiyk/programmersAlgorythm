package programmers.level2;

public class 점프와_순간_이동 {

    public int solution(int n) {
        //n을 2로 나누는데
        //나누어 떨어지지 않으면 1칸 점프
        //n이 1이 될 때까지 반복

        int answer = 1;

        while(n > 1) {
            if(n % 2 != 0) {
                n -= 1;

                answer++;
            }
            else {
                n /= 2;
            }
        }

        return answer;
    }
}
