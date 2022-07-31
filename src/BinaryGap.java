public class BinaryGap {

    public int solution(int N) {
        StringBuilder sb = new StringBuilder();
        while(N > 0){
            sb.append(N % 2);
            N /= 2;
        }
        String binary = sb.reverse().toString();
        int answer = 0;
        int cnt = 0;
        for(int i=0; i<binary.length(); i++){
            if(binary.charAt(i) == '1') {
                if(cnt > answer) {answer = cnt;}
                cnt = 0;
                continue;
            }
            cnt++;
        }
        return answer;
    }

    public int solution2(int N) {
        StringBuilder sb = new StringBuilder();
        while(N > 0){
            sb.append(N % 2);
            N /= 2;
        }
        String binary = sb.reverse().toString();
        String[] arr = binary.split("\\b1[0]+1\\b");
        System.out.println(arr);
        return 0;
    }

    public static void main(String[] args) {
        int n = 32;
        BinaryGap o = new BinaryGap();
        System.out.println(o.solution2(n));
    }
}
