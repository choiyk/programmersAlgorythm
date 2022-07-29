public class SooBackSoo {

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            if(i % 2 == 1) sb.append("박");
            else sb.append("수");
        }
        return sb.toString();
    }

    public String solition2(int n) {
        return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
    }

    public static void main(String[] args) {
        int n = 3;
        SooBackSoo o = new SooBackSoo();
        System.out.println(o.solution(n));
    }
}
