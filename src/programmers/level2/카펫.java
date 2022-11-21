package programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 카펫 {

    public int[] solution(int brown, int yellow) {
        //yellow의 약수를 구한다.
        //구한 약수가 더 작거나 같은 경우만 저장해둔다. (가로 >= 세로)
        //중간 값부터 확인
        //계산된 brown의 값이 크면 height를 키운다.
        //둘러싼다는 것은 노랑의 테두리 만큼의 개수 + 모서리 4개
        //노랑의 개수에 따라 만들 수 있는 사각형이 여러 개
        //그에 따라 사용되는 갈색의 수를 계산
        //맞는 답이 나오면 결과 리턴

        List<Integer> heights = new ArrayList<>();

        for(int i = 1; i * i <= yellow; i++) {
            if(yellow % i == 0)
                heights.add(i);
        }

        int middle = 0 + ((heights.size() - 1) / 2);

        while(middle >= 0 && middle < heights.size()) {
            int height = heights.get(middle);
            int width = yellow / height;
            int brownCnt = (height + width) * 2 + 4;

            if(brownCnt == brown)
                return new int[]{width + 2, height + 2};
            else if(brownCnt > brown)
                middle++;
            else middle--;
        }

        return new int[]{-1, -1};
    }
}
