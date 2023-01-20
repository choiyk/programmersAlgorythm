package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 방문_길이 {

    private Set<String> visited = new HashSet<>();
    private int x = 0, y = 0;

    public int solution(String dirs) {
        //방문한 좌표를 표시할 Set
        //이동 시 이동한 좌표를 set에 저장
        //이동 시 이동할 수 있는 범위를 벗어나면 다음 명령어 실행

        for(String dir : dirs.split("")) {
            if(dir.equals("U") && isValid(x, y + 1)) {
                moveVertical(1);
            }
            else if(dir.equals("D") && isValid(x, y - 1)) {
                moveVertical(-1);
            }
            else if(dir.equals("R") && isValid(x + 1, y)) {
                moveHorizon(1);
            }
            else if(dir.equals("L") && isValid(x - 1, y)) {
                moveHorizon(-1);
            }
        }

        return visited.size();
    }

    private void moveHorizon(int move) {
        StringBuilder line = new StringBuilder();

        if(move < 0) {
            line.append((x + move));
            line.append(y);
            line.append(x);
            line.append(y);
        }
        else {
            line.append(x);
            line.append(y);
            line.append((x + move));
            line.append(y);
        }

        visited.add(line.toString());

        x = x + move;
    }

    private void moveVertical(int move) {
        StringBuilder line = new StringBuilder();

        if(move < 0) {
            line.append(x);
            line.append((y + move));
            line.append(x);
            line.append(y);
        }
        else {
            line.append(x);
            line.append(y);
            line.append(x);
            line.append((y + move));
        }

        visited.add(line.toString());

        y = y + move;
    }

    private boolean isValid(int x, int y) {
        if(!(x <= 5 && x >= -5) || !(y <= 5 && y >= -5))
            return false;

        return true;
    }
}
