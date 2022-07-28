public class SumBetweenNum {

    public long solution(int a, int b) {
        int big, small;
        if(a < b) {big = b; small = a;}
        else {big = a; small = b;}

        long answer = 0;
        for(;small <= big; small++){
            answer += small;
        }

        return answer;
    }

    public static void main(String[] args) {
        SumBetweenNum o = new SumBetweenNum();
        System.out.println(o.solution(3, 3));
    }
}
