package ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class GraphProcessing {

    private boolean[][] graph;
    private ArrayList<Integer> dominants;
    private int minSchoolNumber;
    private int m_V;

    public GraphProcessing(boolean[][] graph, int V) {
        this.graph = graph;
        m_V = V;
    }

    public int getMinSchoolNumber(){
        if (dominants == null)
            findMinSchoolNumber();
        return minSchoolNumber;
    }

    private void findMinSchoolNumber(){
        dominants = new ArrayList<>();
        for (int u = 0; u < m_V; u++) {
            for (int v = 0; v < m_V; v++) {
                if (bfs(u, v))
                    dominants.remove(Integer.valueOf(v));
            }
            dominants.add(u);
        }
        minSchoolNumber = dominants.size();
    }

    /**
     * Returns true if there is a path from source 's' to sink
     * 't' in graph.
     * path
     * @param s         Source
     * @param t         Sink
     * @return          True if t found. Otherwise false
     */
    private boolean bfs(int s, int t)
    {

        // Create a visited array and mark all vertices as not
        // visited
        boolean[] visited = new boolean[m_V];
        Arrays.fill(visited, false);

        // Create a queue, enqueue source vertex and mark
        // source vertex as visited
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        //parent[s]=-1;

        // Standard BFS Loop
        while (queue.size()!=0)
        {
            int u = queue.poll();

            for (int v=0; v<m_V; v++)
            {
                if (visited[v] == false && graph[u][v])
                {
                    queue.add(v);
                    //parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        // If we reached sink in BFS starting from source, then
        // return true, else false
        return (visited[t] == true);
    }
}
