package programmers.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 스킬트리 {

    public int solution(String skill, String[] skill_trees) {
        //스킬을 해시맵에 담는다.
        //해시맵에 해당 스킬이 있는지 확인한다.
        //없으면 통과
        //있으면 스킬배움 index에 해당하는 스킬과 일치하는지 확인한다.

        Set<Character> skillMap = new HashSet<>(skill.length());

        for(char c : skill.toCharArray()) {
            skillMap.add(c);
        }

        int answer = 0;

        for(String skillTree : skill_trees) {
            int skillIdx = 0;

            int i = 0;
            final char[] chars = skillTree.toCharArray();
            for(; i < skillTree.length(); i++) {
                if(skillMap.contains(chars[i])) {
                    if (skill.charAt(skillIdx) == chars[i])
                        skillIdx++;
                    else
                        break;
                }
            }

            if(i == chars.length)
                answer++;
        }

        return answer;
    }
}
