import java.util.*;
public class Main {
    static int[][] graph;
    static String[] names;
    static int size;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("campus.txt"));
        size = sc.nextInt();
        names = new String[size];
        for (int i = 0; i< size; i++) {
            names[i]=sc.next();
        }

        graph= new int[size][size];
        int edges =sc.nextInt();
        for (int i = 0; i<edges; i++) {
            int v1=sc.nextInt();
            int v2 =sc.nextInt();
            int weight= sc.nextInt();
            addEdge(v1, v2, weight);
        }

        int start =sc.nextInt();
        int dest= sc.nextInt();
        sc.close();

        System.out.println("=== BFS from " + names[start] + " ===");
        List<Integer> bfsOrder= bfs(start);
        printPath(bfsOrder);

        System.out.println("=== DFS from " + names[start] + " ===");
        List<Integer> dfsOrder= new ArrayList<>();
        boolean[] dfsVisited =new boolean[size];
        dfs(start, dfsVisited, dfsOrder);
        printPath(dfsOrder);

        dijkstraAlg(start, dest);
    }

    public static void addEdge(int v1, int v2, int weight) {
        graph[v1][v2] =weight;
        graph[v2][v1]= weight;
    }

    public static void printPath(List<Integer> path) {
        for (int i = 0; i<path.size(); i++) {
            System.out.print(names[path.get(i)]);
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static List<Integer> bfs(int start) {
        List<Integer> order= new ArrayList<>();
        boolean[] visited =new boolean[size];
        Queue<Integer> queue= new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr =queue.poll();
            order.add(curr);

            for (int i = 0; i < size; i++) {
                if (graph[curr][i] > 0 && !visited[i]) {
                    visited[i] =true;
                    queue.add(i);
                }
            }
        }
        return order;
    }

    public static void dfs(int curr, boolean[] visited, List<Integer> order) {
        visited[curr] =true;
        order.add(curr);

        for (int i = 0; i <size; i++) {
            if (graph[curr][i]> 0 && !visited[i]) {
                dfs(i, visited, order);
            }
        }
    }

    public static int findTheNextNode(int[] dist, boolean[] visited) {
        int minDist= Integer.MAX_VALUE;
        int minNode= -1;

        for (int i = 0; i< size; i++) {
            if (!visited[i] && dist[i] < minDist) {
                minDist =dist[i];
                minNode= i;
            }
        }
        return minNode;
    }

    public static void route(int[] prev, int curr) {
        if (curr == -1) {
            return;
        }
        route(prev, prev[curr]);
        System.out.print(names[curr]);
        
    }
    public static void printRoute(int[] prev, int dest) {
        List<Integer> path = new ArrayList<>();
        int curr =dest;
        while (curr != -1) {
            path.add(curr);
            curr =prev[curr];
        }
        Collections.reverse(path);
        for (int i = 0; i<path.size(); i++) {
            System.out.print(names[path.get(i)]);
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void dijkstraAlg(int start, int dest) {
        int[] dist =new int[size];
        boolean[] visited= new boolean[size];
        int[] prev =new int[size];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[start] = 0;

        for (int count = 0; count< size - 1; count++) {
            int u = findTheNextNode(dist, visited);
            if (u == -1) {
                break;
            }
            visited[u] = true;

            for (int v = 0; v < size; v++) {
                if (!visited[v] && graph[u][v] > 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v]= dist[u] + graph[u][v];
                    prev[v]= u;
                }
            }
        }

        System.out.println("=== Shortest Time from " + names[start] + " ===");
        int maxLen = 0;
        for (int i = 0; i<size; i++) {
            if (names[i].length() > maxLen) {
                maxLen = names[i].length();
            }
        }

        for (int i = 0; i <size; i++) {
            String padding = "";
            int diff = maxLen - names[i].length();
            for (int p = 0; p <diff; p++) {
                padding += " ";
            }
            System.out.println(names[i] + padding + " : " + dist[i] + " min");
        }

        System.out.println("=== Shortest Route from " + names[start] + " to " + names[dest] + " ===");
        printRoute(prev, dest);
        System.out.println("Total time: " + dist[dest] + " min");
    }
}