import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Cell {
    int parent_i, parent_j;
    double f, g, h;

    Cell() {
        this.parent_i = 0;
        this.parent_j = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
    }
}

public class AStarAlgorithm {
    private static final int ROW = 10;
    private static final int COL = 10;

    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                         { 1, 1, 1, 0, 1, 1, 1, 0, 1, 1 },
                         { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                         { 0, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
                         { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                         { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                         { 1, 0, 0, 0, 0, 1, 1, 0, 0, 1 },
                         { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                         { 1, 1, 1, 0, 0, 0, 1, 0, 0, 1 },
                         { 1, 1, 1, 0, 0, 0, 1, 0, 0, 1 } };
        int[] src = {9, 9};
        int[] dest = {0, 0};
        aStarSearch(grid, src, dest);
    }

    private static boolean isValid(int row, int col) {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL);
    }

    private static boolean isUnblocked(int[][] grid, int row, int col) {
        return grid[row][col] == 1;
    }

    private static boolean isDestination(int row, int col, int[] dest) {
        return (row == dest[0]) && (col == dest[1]);
    }

    private static double calculateHValue(int row, int col, int[] dest) {
        return Math.sqrt((row-dest[0])*(row-dest[0])+(col-dest[1])*(col-dest[1]));
    }

    private static void tracePath(Cell[][] cellDetails, int[] dest) {
        System.out.println("The Path is ");
        int row = dest[0];
        int col = dest[1];
        Map<int[], Boolean> path = new LinkedHashMap<>();
        while(!(cellDetails[row][col].parent_i == row && cellDetails[row][col].parent_j == col)) {
            path.put(new int[] {row, col}, true);
            int temp_row = cellDetails[row][col].parent_i;
            int temp_col = cellDetails[row][col].parent_j;
            row = temp_row;
            col = temp_col;
        }
        path.put(new int[] {row, col}, true);
        List<int[]> pathList = new ArrayList<>(path.keySet());
        Collections.reverse(pathList);
        pathList.forEach(p -> {
            if (p[0] == 2 || p[0] == 1) {
                System.out.print("-> (" + p[0] + ", "
                                 + (p[1]) + ")");
            }
            else {
                System.out.print("-> (" + p[0] + ", " + p[1]
                                 + ")");
            }
        });
        System.out.println();
    }

    private static void aStarSearch(int[][] grid, int[] src, int[] dest) {
        if(!isValid(src[0], src[1]) && !isValid(dest[0], dest[1])) {
            System.out.println("Source or Destination is Invalid");
            return;
        }
        if(!isUnblocked(grid, src[0], src[1]) && !isUnblocked(grid, dest[0], dest[1])) {
            System.out.println("Source or Destination is Blocked");
            return;
        }
        if(isDestination(src[0], src[1], dest)) {
            System.out.println("Already at destination");
            return;
        }
        boolean[][] closedList = new boolean[ROW][COL];
        Cell[][] cellDetails = new Cell[ROW][COL];
        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COL; j++) {
                cellDetails[i][j] = new Cell();
                cellDetails[i][j].f = (int) 1e8;
                cellDetails[i][j].g = (int) 1e8;
                cellDetails[i][j].h = (int) 1e8;
                cellDetails[i][j].parent_i = -1;
                cellDetails[i][j].parent_j = -1;
            }
        }
        int i = src[0];
        int j = src[1];
        cellDetails[i][j].f = 0;
        cellDetails[i][j].g = 0;
        cellDetails[i][j].h = 0;
        cellDetails[i][j].parent_i = i;
        cellDetails[i][j].parent_j = j;
        Map<Double, int[]> openList = new HashMap<>();
        openList.put(0.0, new int[] {i, j});
        boolean foundDest = false;
        while(!openList.isEmpty()) {
            Map.Entry<Double, int[]> p =openList.entrySet().iterator().next();
            for(Map.Entry<Double, int[]> q: openList.entrySet()) {
                if(q.getKey() < p.getKey()) {
                    p = q;
                }
            }
            openList.remove(p.getKey());
            i = p.getValue()[0];
            j = p.getValue()[1];
            closedList[i][j] = true;
            double newF, newG, newH;
             int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}};
             for(int[] d: directions) {
                int ni = i + d[0];
                int nj = j + d[1];
                if(isValid(ni, nj)) {
                    if(isDestination(ni, nj, dest)) {
                        cellDetails[ni][nj].parent_i = i;
                        cellDetails[ni][nj].parent_j = j;
                        System.out.println(
                            "The destination cell is found");
                        tracePath(cellDetails, dest);
                        foundDest = true;
                        return;
                    }  else if (!closedList[ni][nj] && isUnblocked(grid, ni, nj)) {
                        newG = cellDetails[i][j].g + 1;
                        newH = calculateHValue(ni, nj, dest);
                        newF = newG + newH;
                        if(cellDetails[ni][nj].f == (int) 1e8 || cellDetails[ni][nj].f > newF) {
                            openList.put(newF, new int[] {ni, nj});
                            cellDetails[ni][nj].f = newF;
                            cellDetails[ni][nj].g = newG;
                            cellDetails[ni][nj].h = newH;
                            cellDetails[ni][nj].parent_i = i;
                            cellDetails[ni][nj].parent_j = j;
                        }
                    }
                } 
            }
       }
       if (!foundDest)
            System.out.println(
                "Failed to find the destination cell");
    }
}