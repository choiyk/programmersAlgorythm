package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와_BFS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        Queue<Integer>[] nodes = new Queue[N+1];
        Queue<Integer>[] nodes2 = new Queue[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if(nodes[n1] == null)
                nodes[n1] = new PriorityQueue<>();

            if(nodes[n2] == null)
                nodes[n2] = new PriorityQueue<>();

            nodes[n1].add(n2);
            nodes[n2].add(n1);

            if(nodes2[n1] == null)
                nodes2[n1] = new PriorityQueue<>();

            if(nodes2[n2] == null)
                nodes2[n2] = new PriorityQueue<>();

            nodes2[n1].add(n2);
            nodes2[n2].add(n1);
        }

        br.close();

        int[] visited = new int[N+1];
        List<Integer> dfs = new ArrayList<>(N);
        List<Integer> bfs = new ArrayList<>(N);

        dfs(nodes, V, dfs);
        bfs(nodes2, V, bfs);

        StringBuilder sb = new StringBuilder();
        for(int n : dfs) {
            sb.append(n + " ");
        }
        if(sb.length() > 0)
            sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());

        sb = new StringBuilder();
        for(int n : bfs) {
            sb.append(n + " ");
        }
        if(sb.length() > 0)
            sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

    private static void dfs(Queue<Integer>[] nodes, int n, List<Integer> dfs) {
        dfs.add(n);

        if(nodes[n] == null)
            return;

        while(!nodes[n].isEmpty()) {
            int next = nodes[n].poll();

            if(dfs.contains(next))
                continue;

            dfs(nodes, next, dfs);
        }
    }

    private static void bfs(Queue<Integer>[] nodes, int start, List<Integer> bfs) {
        Queue<Integer> queue = new LinkedList<>();
        bfs.add(start);
        queue.add(start);

        while(!queue.isEmpty()) {
            int n = queue.poll();

            while(nodes[n] != null && !nodes[n].isEmpty()) {
                int next = nodes[n].poll();

                if(bfs.contains(next))
                    continue;

                bfs.add(next);
                queue.add(next);
            }
        }
    }
}
