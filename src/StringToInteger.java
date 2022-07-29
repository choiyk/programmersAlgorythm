public class StringToInteger {

    public int solution(String s) {
        int sign = 1;
        if(s.charAt(0) == '+') {
            s = s.substring(1);
        }
        else if(s.charAt(0) == '-') {
            s = s.substring(1);
            sign = -1;
        }

        int answer = Integer.valueOf(s);
        return answer * sign;

        //return Integer.parseIn(s); 하면 부호가 있어도 상관 없다.
    }

    public int solution2(String s) {
        int sign = 1;
        int answer = 0;

        if(s.charAt(0) == '+') {
            s = s.substring(1);
        }
        else if(s.charAt(0) == '-') {
            s = s.substring(1);
            sign = -1;
        }

        for(int i=0; i<s.length(); i++){
            answer = answer * 10 + (s.charAt(i) - '0');
        }

        return sign * answer;
    }

    public static void main(String[] args) {
        String s = "-1234";
        StringToInteger o = new StringToInteger();
        System.out.println(o.solution2(s));
    }
}
