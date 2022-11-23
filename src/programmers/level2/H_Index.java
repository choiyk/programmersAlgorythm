package programmers.level2;

import java.util.Arrays;

public class H_Index {

    public int solution(int[] citations) {
        //배열을 정렬
        //배열을 가리키는 포인터 i
        //h를 하나씩 증가시킴
        //citations[i]가 h보다 작으면 i++
        //h와 개수가 같아지면 리턴

        Arrays.sort(citations);

        int h = 0;
        int i = 0;

        while(i < citations.length && h < citations.length) {
            while (i < citations.length && citations[i] < h) {
                i++;
            }

            final int books = citations.length - i;

            if (h == books) {
                break;
            }
            else if(h > books) {
                h--;
                break;
            }

            h++;
        }

        return h;
    }
}
