public class StrangeString {

    public String solution(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int sign = 0;
        for(int i=0; i<chars.length; i++){
            if(chars[i] == 32) {sign = 0; continue;}
            if(sign == 0) {
                chars[i] = (char)(chars[i] - 32);
                sign = 1;
            }
            else sign = 0;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "try hello world";
        StrangeString o = new StrangeString();
        System.out.println(o.solution(s));
    }
}
