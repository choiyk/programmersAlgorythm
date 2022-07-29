public class PrimeNumber {

    public int solution(int n) {
        int answer = 0;
        for(int i=2; i <= n; i++){
            if(findPrimeNumber(i, i-1) == 1) answer++;
        }
        return answer;
    }

    public int findPrimeNumber(int target, int divider){
        if(divider <= 1) return 1;
        if(target % divider == 0) return 0;
        return findPrimeNumber(target, divider-1);
    }

    //효율성 똥망 실패!
    public static void main(String[] args) {
        int n = 5;
        PrimeNumber o = new PrimeNumber();
        System.out.println(o.solution(n));
    }
}
