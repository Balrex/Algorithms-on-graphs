import java.util.ArrayList;

public class TestGraphA {
    public static void main(String[] args) {
        int[][] A = {{0,1,1,1,0}, {1,0,0,1,1}, {1,0,0,0,0}, {1,1,0,0,0}, {0,1,0,0,0}};
        GraphA test = new GraphA();
        System.out.println(test.DFS(A));
        System.out.println(test.BFS(A));

        A= new int[][]{{0, 7, 8, 6, 0, 0, 0, 0}, {7, 0, 2, 0, 11, 0, 0, 0}, {8, 2, 0, 7, 10, 3, 5, 0}, {6, 0, 7, 0, 0, 0, 10, 0}, {0, 11, 10, 0, 0, 6, 0, 19}, {0, 0, 3, 0, 6, 0, 12, 7}, {0, 0, 5, 10, 0, 12, 0, 4}, {0, 0, 0, 0, 19, 7, 4, 0}};
        System.out.println(test.Dijkstra(A, 0));

        node[] path = test.Prima(A, 0);
        for (int i=0; i<A[0].length; ++i)
            System.out.println("из "+i+" "+path[i].sum+" до "+path[i].prev);

    }
}
