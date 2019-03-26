package euler28.main;

public class Euler28 {
    public static int[][] grid = new int[1001][1001];

    public static void main(String[] args) {
        initGrid();
        printGrid();
        System.out.println(grid[(grid.length - 1) / 2][(grid.length - 1) / 2]);
        System.out.println("" + (checkLeftDiagonal() + checkRightDiagonal() - 1));
    }

    public static long checkRightDiagonal() {
        int i = 0, j = 0, sum = 0;

        while(i < grid.length) {
            sum += grid[i][j];
            i++;
            j++;
        }

        return sum;
    }

    public static long checkLeftDiagonal() {
        int i = grid.length - 1, j = 0, sum = 0;

        while(i >= 0) {
            sum += grid[i][j];
            i--;
            j++;
        }

        return sum;
    }

    public static void initGrid() {
        int direction = 3;

        int number = grid.length * grid.length;
        int x = grid.length - 1;
        int y = 0;

        while(true) {
            System.out.println("x: " + x + ", y: " + y + ", printing: " + number);
            grid[x][y] = number;
            if(number == 1) {
                break;
            }
            number--;

            if(direction == 3) {
                if(x - 1 < 0 || grid[x - 1][y] != 0) {
                    direction = 2;
                    y++;
                } else {
                    x--;
                }
                continue;
            }
            if(direction == 2) {
                if(y + 1 >= grid.length || grid[x][y + 1] != 0) {
                    direction = 1;
                    x++;
                } else {
                    y++;
                }
                continue;
            }
            if(direction == 1) {
                if(x + 1 >= grid.length || grid[x + 1][y] != 0) {
                    direction = 0;
                    y--;
                } else {
                    x++;
                }
                continue;
            }
            if(direction == 0) {
                if(y - 1 < 0 || grid[x][y - 1] != 0) {
                    direction = 3;
                    x--;
                } else {
                    y--;
                }
            }
        }
    }

    public static void printGrid() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[j][i] < 10) {
                    System.out.print("0");
                }
                System.out.print(grid[j][i] + " ");
            }
            System.out.println("");
        }
    }
}
