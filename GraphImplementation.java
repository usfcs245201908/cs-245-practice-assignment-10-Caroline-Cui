import java.util.List;
import java.util.ArrayList;


public class GraphImplementation implements Graph
{
    private int[][] graph;
    private int size;
//constructor
    public GraphImplementation(int vertices)
    {
        graph = new int[vertices][vertices];
        size = vertices;
    }
//start from v1 to v2
    @Override
    public void addEdge(int v1, int v2) throws Exception
    {
        if (v1 > size||v2 > size||v1 < 0||v2 < 0)
            throw new Exception();
        graph[v1][v2] = 1;
    }

//use topological sort to sort the graph
    @Override
    public List<Integer> topologicalSort()
    {
        List<Integer> s = new ArrayList<Integer>();
        int[] sum = new int[size];
        for(int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
                sum[j] += graph[i][j];
        }


        for(int count = 0; count < size; count++)
        {
                int n = findZero(sum);
                if(n == -1)
                {
                    System.out.print("Wrong!");
                    System.exit(0);
                }
                s.add(n);
                sum[n] = -1;
                for(int i = 0; i < size; i++)
                    sum[i] -= graph[n][i];
            }
            return s;
        }

    private int findZero(int[] arr)
    {
        for(int i = 0; i <arr.length; i++)
        {
            if(arr[i] == 0)
                return i;
        }
        return -1;
    }

//give neighbor for a given vertex
        @Override
    public List<Integer> neighbors(int vertex) throws Exception
    {
        if(vertex > size || vertex < 0)
            throw new Exception();
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < size; i++){
            if(graph[vertex][i] == 1)
                result.add(i);
        }
        return result;
    }

}

