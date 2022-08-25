package javaCodingInterview.Chapter10;

public class OneEditAway {

    public boolean solution(String p, String q) {
        if(Math.abs(p.length() - q.length()) > 1) return false;

        String shorter = p.length() < q.length() ? p : q;
        String longer = p.length() >= q.length() ? p : q;

        int is=0;
        int il=0;
        boolean marker = false;

        while (is < shorter.length() && il < longer.length()) {
            if(shorter.charAt(is) != longer.charAt(il)) {
                if(marker) return false;
                marker = true;
                il++;
                continue;
            }
            is++;
            il++;
        }

        return true;
    }
}
