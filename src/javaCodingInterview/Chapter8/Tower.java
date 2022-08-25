package javaCodingInterview.Chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Tower {

    /** 풀이1 */
    public int solution(int[][] boxes) {
        //boxes[n][0] : width, boxes[n][1] : height, boxes[n][2] : color
        List<Integer> answers = new ArrayList<>();
        computeHeight(0, new int[boxes.length], boxes, boxes[0][1], answers);
        Integer[] answersArr = answers.toArray(new Integer[answers.size()]);
        Arrays.sort(answersArr);
        return answersArr[answersArr.length-1];
    }

    public void computeHeight(int lastBox, int[] used, int[][] boxes, int totalHeight, List<Integer> answers) {
        used[lastBox] = -1;

        for(int i=0; i< used.length; i++) {
            if(used[i] != -1) {
                if(boxes[i][0] < boxes[lastBox][0] && boxes[i][1] < boxes[lastBox][1] && boxes[i][2] != boxes[lastBox][2]){
                    computeHeight(i, used, boxes, totalHeight + boxes[i][1], answers);
                }
            }
        }

        answers.add(totalHeight);
    }

    /** 풀이2 */
    public int solution2(int[][] boxes) {
        //boxes[n][0] : width, boxes[n][1] : height, boxes[n][2] : color
        //상자를 크기 순으로 정렬
        List<Box> boxList = new ArrayList<>(boxes.length);
        for(int i=0; i<boxes.length; i++) {
            boxList.add(new Box(boxes[i][0], boxes[i][1], boxes[i][2]));
        }
        boxList.sort(Comparator.reverseOrder());

        //메모이제이션
        int[] cache = new int[boxes.length];

        computeHeight2(0, boxList, cache);
        Arrays.sort(cache);

        return cache[cache.length-1];
    }

    private int computeHeight2(int index, List<Box> boxes, int[] cache) {
        if(cache[index] > 0) return cache[index];

        Box currentBox = boxes.get(index);
        int highest = 0;

        for(int i=index+1; i< boxes.size(); i++) {
            Box nextBox = boxes.get(i);
            if(currentBox.canPutNext(nextBox)) {
                int height = computeHeight2(i, boxes, cache);
                highest = Math.max(highest, height);
            }
        }

        highest += currentBox.height;
        cache[index] = highest;
        return highest;
    }

    class Box implements Comparable<Box> {
        private int width;
        private int height;
        private int color;

        public Box(int width, int height, int color) {
            this.width = width;
            this.height = height;
            this.color = color;
        }

        @Override
        public int compareTo(Box o) {
            if(this.width != o.width) return this.width - o.width;
            else if(this.height != o.height) return this.height - o.height;
            else return this.color - o.color;
        }

        public boolean canPutNext(Box o) {
            if(this.width <= o.width) return false;
            else if(this.height <= o.height) return false;
            else if(this.color == o.color) return false;
            return true;
        }
    }
}
