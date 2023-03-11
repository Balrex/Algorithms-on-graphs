import java.util.ArrayList;
import java.util.LinkedList;

public class GraphA {
    private LinkedList<Integer> elements = new LinkedList<>();

    public GraphA(){
    }

    //поиск в глубину
    public ArrayList<Integer> DFS (int [][] orig){
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[orig[0].length];
        for (int i=0; i<orig[0].length; ++i)
            visited[i] = false;
        path=InDepth(0, orig, path, visited);
        return path;
    }

    private ArrayList<Integer> InDepth(int peak, int[][] orig, ArrayList<Integer> path, boolean[] visited){
        visited[peak]=true;
        path.add(peak);
        for (int i=peak, j=0; j<visited.length; ++j)
            if (visited[j]==false && orig[i][j]!=0)
                path = InDepth(j, orig, path, visited);
        return path;
    }

    //поиск в ширину
    public ArrayList<Integer> BFS (int [][] orig){
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[orig[0].length];
        for (int i=0; i<orig[0].length; ++i)
            visited[i] = false;

        elements.offer(0); //очередь
        visited[0]=true;                                       //необходимо, т.к. инчане 0 отметится в очереди потом ещё раз
        while (elements.peek()!=null) {
            int peak = elements.poll();
            path.add(peak);
            for (int i=peak, j=0; j<visited.length; ++j)
                if (visited[j]==false && orig[i][j]!=0){
                    elements.offer(j);
                    visited[j]=true;
                }
        }
        return path;
    }

    //алгоритм Дейкстры
    public ArrayList<Integer> Dijkstra(int[][] orig, int start){
        ArrayList<Integer> path = new ArrayList<>();
        node[] D = new node[orig[0].length];
        boolean[] visited = new boolean[orig[0].length];
        for (int i=0; i<visited.length; ++i){
            D[i] = new node(i, Integer.MAX_VALUE);
            visited[i]=false;
        }

        D[start].sum=0;
        D[start].prev=-5;
        int count=visited.length, tmp=start;
        while (count>0){
//            System.out.println("*******************************");
//            System.out.println("Находимся в: "+tmp);
            for (int i=tmp, j=0; j<visited.length; ++j) {
//                System.out.println(D[tmp].sum + orig[i][j]);
                if (orig[i][j] != 0 && D[tmp].sum + orig[i][j] < D[j].sum) {
                    D[j].sum = D[tmp].sum + orig[i][j];
                    D[j].prev = tmp;
//                    System.out.println("-----: "+j);
                }
            }
            visited[tmp]=true;
            count--;
            int min=Integer.MAX_VALUE;
            for (int i=0; i<visited.length; ++i)
                if (D[i].sum<min && visited[i]!=true)
                    tmp=i;
        }

        path.add(visited.length-1);
        int i = D[visited.length-1].prev;
        do {
            path.add(i);
            i = D[i].prev;
        }while (i !=-5);
        return path;
    }

    //алгоритм Прима
    public node[] Prima(int[][] orig, int start){
        node[] D = new node[orig[0].length];
        int tmp=start, count=orig[0].length;
        boolean[] visited = new boolean[orig[0].length];
        for (int i=0; i<orig[0].length; ++i) {
            D[i] = new node(i, Integer.MAX_VALUE);
            visited[i] = false;
        }

        D[start].sum=0;
        D[start].prev=-5;
        while(count>0) {
            System.out.println("*******************************");
            System.out.println("Находимся в: " + tmp);
            for (int i = tmp, j = 0; j < orig[0].length; ++j) {
                System.out.println(D[tmp].sum + orig[i][j]);
                if (orig[i][j] != 0 && orig[i][j] < D[j].sum && visited[j]!=true) {
                    D[j].sum = orig[i][j];
                    D[j].prev = i;
                    System.out.println("-----: " + j);
                }
            }
            visited[tmp] = true;
            count--;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < visited.length; ++i)
                if (D[i].sum < min && visited[i] != true)
                    tmp = i;
        }
        return D;
    }

}
