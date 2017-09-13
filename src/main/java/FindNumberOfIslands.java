/**
 * Created by Tapan on 9/2/2017.
 */
public class FindNumberOfIslands {

    private int[][] matrix;
    private int[][] visited;
    private int count = 0;
    private int numberOfIslands;
    public int find(int[][]matrix) {
        this.matrix = matrix;
        this.count = matrix.length;
        this.visited = new int[count][count];

        for (int i=0; i < count; i++) {
            for (int j=0; j<count; j++) {
                if (!isVisited(i,j) && canVisit(i,j)) {
                    applyDFS(i,j);
                  numberOfIslands++;
                }
            }
        }

        return numberOfIslands;
    }

    private void applyDFS(int i, int j) {
        visitIfNotVisited(i - 1,j -1);
        visitIfNotVisited(i, j -1);
        visitIfNotVisited(i+1, j -1);
        visitIfNotVisited(i -1 ,j );
        visitIfNotVisited(i + 1, j);
        visitIfNotVisited(i-1 , j+1);
        visitIfNotVisited(i,j+1);
        visitIfNotVisited(i +1, j+1);
    }

    private void visitIfNotVisited(int i, int j) {
        if (i < 0 || i >= count || j < 0 || j>=count) {
            return;
        }
        if (isVisited(i,j)) {
            return;
        }

        if (canVisit(i,j)) {
            visited[i][j] = 1;
            applyDFS(i, j);
        }
    }

    private boolean canVisit(int i, int j) {
        return matrix[i][j] == 1;
    }

    boolean isVisited(int i,int j) {
        return visited[i][j] == 1;
    }
}
