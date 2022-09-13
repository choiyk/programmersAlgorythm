package javaCodingInterview.Chapter13;

import java.util.*;

public class DirectGraphPath {

    public boolean solutionByBfs(String[] graphStr, String from, String to) {
        Graph<String> graph = new Graph<>();

        for(int i=0; i< graphStr.length/2; i++) {
            graph.addEdge(graphStr[2*i], graphStr[(2*i)+1]);
        }

        return graph.isPathByBfs(from, to);
    }

    public boolean solutionByDfs(String[] graphStr, String from, String to) {
        Graph<String> graph = new Graph<>();

        for(int i=0; i< graphStr.length/2; i++) {
            graph.addEdge(graphStr[2*i], graphStr[(2*i)+1]);
        }

        return graph.isPathByDfs(from, to);
    }

    class Graph<T> {
        //정점 리스트
        private final Map<T, List<T>> adjacencyList;

        public Graph() {
            this.adjacencyList = new HashMap<>();
        }

        public boolean addEdge(T from, T to) {
            if(from == null || to == null) return false;

            List<T> adjacents = adjacencyList.get(from);
            if(adjacents == null) {
                adjacents = new ArrayList<>();
                adjacencyList.put(from, adjacents);
            }

            adjacents.add(to);

            return true;
        }

        //너비 우선 탐색
        public boolean isPathByBfs(T from, T to) {
            if(from == null || to == null) return false;
            if(from == to) return true;

            Queue<T> queue = new ArrayDeque<>();
            Set<T> visited = new HashSet<>();

            visited.add(from);
            queue.offer(from);

            while(!queue.isEmpty()) {
                T e = queue.poll();

                List<T> adjacents = adjacencyList.get(e);

                if(adjacents != null) {
                    for(T adjacent : adjacents) {
                        if(adjacent == to) return true;

                        if(adjacent != null && !visited.contains(adjacent)) {
                            visited.add(adjacent);
                            queue.offer(adjacent);
                        }
                    }
                }
            }

            return false;
        }

        //깊이 우선 탐색
        public boolean isPathByDfs(T from, T to) {
            if(from == null || to == null) return false;
            if(from == to) return true;

            Set<T> visited = new HashSet<>();

            return dfsRecursion(from, to, visited);
        }

        private boolean dfsRecursion(T from, T to, Set<T> visited) {
            if(from == to) return true;

            visited.add(from);
            List<T> adjacents = adjacencyList.get(from);

            boolean result = false;

            if(adjacents != null) {
                for(T adjacent : adjacents) {
                    if(adjacent != null && !visited.contains(adjacent)) {
                        result = dfsRecursion(adjacent, to, visited);
                    }
                }
            }

            return result;
        }
    }
}
