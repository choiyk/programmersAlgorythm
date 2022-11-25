package programmers.level2;

import java.util.*;

public class 뉴스_클러스터링 {

    public int solution(String str1, String str2) {
        //합집합은 set
        //교집합은 두 문자열을 비교하며 list에 저장
        //i, j. 같으면 list에 넣고, i < j -> i++, j < i -> j++. 범위를 벗어나면 종료
        //유사도 = list길이 / set 길이

        //i < str.length - 1
        //현재 문자열과 다음 문자열이 영문이면 list에 추가
        //영문이 아니면 i++

        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();

        Queue<String> str1List = toStringList(str1.toLowerCase());
        Queue<String> str2List = toStringList(str2.toLowerCase());

        while(!str1List.isEmpty() && !str2List.isEmpty()) {
            final String s1 = str1List.peek();
            final String s2 = str2List.peek();
            final int res = s1.compareTo(s2);

            if(res == 0) {
                intersection.add(s1);
                union.add(s1);

                str1List.poll();
                str2List.poll();
            }
            else if(res > 0) {
                union.add(s2);
                str2List.poll();
            }
            else {
                union.add(s1);
                str1List.poll();
            }
        }

        while(!str1List.isEmpty()) {
            union.add(str1List.poll());
        }

        while(!str2List.isEmpty()) {
            union.add(str2List.poll());
        }

        double j = intersection.size() + union.size() == 0 ? 1 : (double) intersection.size() / union.size();

        return (int) (j * 65536);
    }

    private Queue<String> toStringList(String str) {
        Queue<String> strList = new PriorityQueue<>();

        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z' && str.charAt(i + 1) >= 'a' && str.charAt(i + 1) <= 'z') {
                strList.add(str.substring(i, i + 2));
            }
        }

        return strList;
    }
}
