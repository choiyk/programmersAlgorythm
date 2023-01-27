package programmers.level2;

import javax.swing.text.Position;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class 프렌즈4블록 {

    public int solution(int m, int n, String[] board) {
        //나를 기준으로 4개 블록 확인
        //i < board.length - 1, j < board[0].length - 1
        //4개 블록 모두 같다면 temp에 지울거라고 표시
        //temp는 set
        //temp를 돌면서 빈칸 처리

        //블록내리기
        //i=0 : 열, j=board.length-1 : 행
        //j를 순회하면서 빈칸을 만나면 빈칸의 개수를 셈
        //빈칸 다음의 블록을 만나면 j + 빈칸의 개수 칸으로 블록을 옮김
        //j가 0이 될때까지 반복

        //더 이상 4개 블록이 없을 때까지 반복

        char[][] blocks = new char[m][n];
        for(int i = 0; i < m; i++) {
            char[] chars = board[i].toCharArray();

            for(int j = 0; j < n; j++) {
                blocks[i][j] = chars[j];
            }
        }

        int answer = 0;

        while(true) {
            int removedBlockCnt = deleteBlock(m, n, blocks);

            if(removedBlockCnt <= 0)
                break;

            answer += removedBlockCnt;

            lineUp(m, n, blocks);
        }

        return answer;
    }

    private int deleteBlock(int m, int n, char[][] blocks) {
        Set<Position> removes = new HashSet<>();

        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < n - 1; j++) {
                final char block = blocks[i][j];

                if(block == ' ')
                    continue;

                if(block == blocks[i][j + 1] && block == blocks[i + 1][j] && block == blocks[i + 1][j + 1]) {
                    removes.add(new Position(i, j));
                    removes.add(new Position(i + 1, j));
                    removes.add(new Position(i, j + 1));
                    removes.add(new Position(i + 1, j + 1));
                }
            }
        }

        final int removedBlockCnt = removes.size();

        for(Position position : removes) {
            blocks[position.x][position.y] = ' ';
        }

        return removedBlockCnt;
    }

    private void lineUp(int m, int n, char[][] blocks) {
        for(int i = 0 ; i < n; i++) {
            int nullBlockCnt = 0;

            for(int j = m - 1; j >= 0; j--) {
                if(blocks[j][i] == ' ')
                    nullBlockCnt++;

                if(nullBlockCnt > 0 && blocks[j][i] != ' ') {
                    blocks[j + nullBlockCnt][i] = blocks[j][i];
                    blocks[j][i] = ' ';
                }
            }
        }
    }

    class Position {
        private int x;
        private int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Position &&
                    ((Position) obj).x == x && ((Position) obj).y == y;
        }
    }
}
