public class FrogJmp {

    public int solution(int X, int Y, int D) {
        if(X == Y) return 0;
        int answer = (Y - X) / D;
        if((Y - X) % D > 0) answer++;
        return answer;
    }

    public static void main(String[] args){
        int X = 10;
        int Y = 85;
        int D = 30;
        FrogJmp o = new FrogJmp();
        System.out.println(o.solution(X, Y, D));
    }
}
