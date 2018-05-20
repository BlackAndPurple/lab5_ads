package ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class GraphProcessing {

    private boolean[][] graph;
    private ArrayList<Integer> dominants;
    private ArrayList<Integer> tDominants;  //dominants for transposed graph
    private int minSchoolNumber;
    private int m_V;
    private int extensionsNumber;

    public GraphProcessing(boolean[][] graph, int V) {
        this.graph = graph;
        m_V = V;
    }

    public int getMinSchoolNumber(){
        if (dominants == null){
            dominants = new ArrayList<>();
            findDominantsSet(dominants, graph);
            minSchoolNumber = dominants.size();
        }
        return minSchoolNumber;
    }

    public int getExtensionsNumber(){
        if (dominants == null) {
            dominants = new ArrayList<>();
            findDominantsSet(dominants, graph);
        }
        if (tDominants == null) {
            tDominants = new ArrayList<>();
            findTransposedDominants();
        }
        //in case if we don't need more edges
        if (dominants.size() == 1 && tDominants.size() == 1 && dominants.get(0).equals(tDominants.get(0)))
            return 0;
        return Math.max(dominants.size(), tDominants.size());
    }

    private void findTransposedDominants(){
        //tDominants = new ArrayList<>();
        boolean[][] tGraph = new boolean[m_V][m_V];
        for (int i = 0; i < m_V; i++)
            for (int j = 0; j < m_V; j++)
                tGraph[i][j] = graph[j][i];
        findDominantsSet(tDominants, tGraph);
    }

    /**
     * Allows to find dominants set in order to get minimum school number
     */
    private void findDominantsSet(ArrayList<Integer> dominants, boolean[][] graph){

        boolean[] visited = new boolean[m_V];
        Arrays.fill(visited, false);

        for (int u = 0; u < m_V; u++) {
            if (visited[u])
                continue;
            for (int v = 0; v < m_V; v++) {
                if (bfs(graph, u, v)) {
                    dominants.remove(Integer.valueOf(v));
                    visited[v] = true;
                }
            }

            if (!visited[u])
            dominants.add(u);
        }
    }

    /**
     * Returns true if there is a path from source 's' to sink
     * 't' in graph.
     * @param graph
     * @param s         Source
     * @param t         Sink
     * @return          True if t found. Otherwise false
     */
    private boolean bfs(boolean[][] graph, int s, int t)
    {
        if (s == t)
            return false;

        // Create a visited array and mark all vertices as not
        // visited
        boolean[] visited = new boolean[m_V];
        Arrays.fill(visited, false);

        // Create a queue, enqueue source vertex and mark
        // source vertex as visited
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        // Standard BFS Loop
        while (queue.size()!=0)
        {
            int u = queue.poll();

            for (int v=0; v<m_V; v++)
            {
                if (visited[v] == false && graph[u][v])
                {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }

        // If we reached sink in BFS starting from source, then
        // return true, else false
        return (visited[t] == true);
    }
}
