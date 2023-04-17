package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의_부모_찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] input = new int[n-1][2];
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        br.close();

        List<Integer>[] nodes = new List[n+1];
        for(int i = 0; i < n-1; i++) {
            if(nodes[input[i][0]] == null)
                nodes[input[i][0]] = new ArrayList<>();

            nodes[input[i][0]].add(input[i][1]);

            if(nodes[input[i][1]] == null)
                nodes[input[i][1]] = new ArrayList<>();

            nodes[input[i][1]].add(input[i][0]);
        }

        int[] answer = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()) {
            int parent = queue.poll();

            for(int child : nodes[parent]) {
                if(child == 1 || answer[child] != 0)
                    continue;

                answer[child] = parent;
                queue.add(child);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < n; i++) {
            sb.append(answer[i]);
            sb.append("\n");
        }
        sb.append(answer[n]);

        System.out.println(sb);
    }
}
