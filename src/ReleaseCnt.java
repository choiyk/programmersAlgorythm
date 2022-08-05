import java.util.*;

public class ReleaseCnt {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> temp = new ArrayList<>();
        int totalReleased = 0;

        while(totalReleased < progresses.length){
            boolean canRelease = false;
            for(int i=0; i<progresses.length; i++){
                if(progresses[i] < 0) continue; //이미 작업이 끝났으면 넘어감

                progresses[i] += speeds[i]; //오늘의 작업

                if(progresses[i] >= 100){
                    progresses[i] = -1; //작업이 끝났으면 -1 표시

                    if(totalReleased == i) canRelease = true;   //배포 가능
                }
            }
            //배포 작업
            if(canRelease){
                int releaseCnt = 0; //오늘의 배포 수량
                for(int i=totalReleased; i<progresses.length; i++){
                    if(progresses[i] == -1 && (i == 0 || progresses[i-1] == -2)){
                        releaseCnt++;
                        progresses[i] = -2;
                    }
                }
                totalReleased += releaseCnt;
                temp.add(releaseCnt);
            }
        }

        int[] answer = new int[temp.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = temp.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};
        ReleaseCnt o = new ReleaseCnt();
        System.out.println(Arrays.toString(o.solution(progresses, speeds)));
    }
}
