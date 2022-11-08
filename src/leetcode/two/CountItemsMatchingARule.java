package leetcode.two;

import java.util.List;

public class CountItemsMatchingARule {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int idx;

        if(ruleKey.equals("type"))
            idx = 0;
        else if(ruleKey.equals("color"))
            idx = 1;
        else
            idx = 2;

        return countMatches(idx, items, ruleValue);
    }

    private int countMatches(int idx, List<List<String>> items, String ruleValue) {
        int cnt = 0;

        for(List<String> item : items) {
            if(item.get(idx).equals(ruleValue))
                cnt++;
        }

        return cnt;
    }

}
