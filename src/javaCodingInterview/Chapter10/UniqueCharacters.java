package javaCodingInterview.Chapter10;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharacters {

    public boolean solution(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        for(char c : s.toCharArray()) {
            if(c == ' ') continue;
            if(map.get(c) == null) map.put(c, 1);
            else return false;
        }
        return true;
    }
}
