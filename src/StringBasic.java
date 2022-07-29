public class StringBasic {

    public boolean solution(String s) {
        if(!(s.length() == 4 || s.length() == 6)) return false;
        return s.chars().filter(c -> c < '0' || c > '9').count() <= 0;
    }

    public static void main(String[] args) {
        String s = "a234";
        StringBasic o = new StringBasic();
        System.out.println(o.solution(s));
    }
}
