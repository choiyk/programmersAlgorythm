package javaCodingInterview.Chapter8;

import java.util.HashSet;
import java.util.Set;

public class FiveTower {
    Set<Integer[]> solutions;
    int GRID_SIZE;

    public int solution(int n) {
        solutions = new HashSet<>();
        GRID_SIZE = n;
        compute(0, new Integer[GRID_SIZE]);
        return solutions.size();
    }

    private void compute(int row, Integer[] path) {
        if(row >= GRID_SIZE) {
            solutions.add(path.clone());
            return;
        }

        for(int j=0; j<GRID_SIZE; j++){
            if(canPutTower(row, j, path)) {
                path[row] = j;    //Put Tower
                compute(row+1, path);
            }
        }
    }

    private boolean canPutTower(int row, int col, Integer[] path) {
        for(int i=0; i<row; i++) {
            if(path[i] == col) return false;    //서로 다른 열
            if((row-i) == Math.abs(path[i] - col)) return false;    //서로 다른 대각선
        }
        return true;
    }
}
