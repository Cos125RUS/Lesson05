import java.util.Random;


public class GenerateMaze {
    int height = 10;
    int width = 10;
    int[][] maze;


    public GenerateMaze(int height, int width) {
        this.height = height;
        this.width = width;
        this.maze = new int[height][width];
    }



    /**
     * Метод создания cтатического лабиринта
     * @param maze лабиринт в виде массива int[10][10], стенки имеют вес = -1
     */
    public int[][] staticMaze(){
    int[][] maze =
            {{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                    {-1, 0, -1, -1, -1, -1, 0, 0, 0, -1},
                    {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
                    {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
                    {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
                    {-1, 0, -1, -1, -1, -1, -1, -1, 0, -1},
                    {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
                    {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};

    return maze;
    }


    /**
     * Метод создания лабиринта простым рандомом
     * @param height высота лабиринта
     * @param width ширина лабиринта
     * @param maze лабиринт в виде массива int[][], стенки имеют вес = -1
     * Возращается двумерный массив maze[height][width]
     */
    public int[][] simple() {
        Random random = new Random();
        boards(maze, height, width, -1);

        for (int i = 1; i < width - 1; i++)
            for (int j = 0; j < height - 1; j++) {
                int r = random.nextInt(4);
                if (r == 0)
                    maze[i][j] = -1;
            }

        return maze;
    }


    /**
     * Метод создания лабиринта алгоритмом Эйлера
     * @param height высота лабиринта
     * @param width ширина лабиринта
     * @param maze лабиринт в виде массива int[][], стенки имеют вес = -1
     * Возращается двумерный массив maze[height][width]
     */
    public void euler(){
        int[][] sets = new int[height][width];
        boards(maze, height, width, -1);
        boards(sets, height, width, 1);

        for (int i = 1; i < height-1; i++){
            fillSetLine(maze, sets, width-1, i);
            System.out.println();
        }


//        return maze;
    }




//    Закрытые методы класса:

    /**
     * Метод создания границ лабиринта
     * @param height высота лабиринта
     * @param width ширина лабиринта
     * @param maze лабиринт в виде массива int[][]
     */
    private static void boards(int[][] maze, int height, int width, int wall){
        for (int i = 0; i < width; i++) {
            maze[0][i] = wall;
            maze[height - 1][i] = wall;
        }
        for (int i = 1; i < height - 1; i++) {
            maze[i][0] = wall;
            maze[i][width - 1] = wall;
        }
    }

    private static void fillSetLine(int[][] maze, int[][] sets, int width, int line) {
        Random random = new Random();
        sets[line][1] = 1;
        System.out.print(sets[line][1] + " ");
        for (int j = 2; j < width - 1; j++) {
            if (random.nextInt(2) == 0)
                sets[line][j] = sets[line][j - 1];
            else {
                maze[line][j] = -1;
                sets[line][j] = ++sets[line][j - 1];
                if (j != width-2){
                    System.out.print(sets[line][j] + " ");
                    sets[line][j+1] = sets[line][j++];
                }
            }
            System.out.print(sets[line][j] + " ");
        }
        sets[line][width - 1] = sets[line][width - 2];
        System.out.print(sets[line][width - 1] + " ");



    }

    private static void buildWall(int[][] maze, int[][] sets, int width, int line){
        Random random = new Random();
        int countWall = 0;
        int countSet = 1;
        for (int j = 1; j < width-1; j++){
            if (sets[line][j] != sets[line][j+1]){
                if (countSet == countWall)
                    maze[line+1][j - random.nextInt(countSet)] = 0;
                countWall = 0;
                countSet = 1;
            }
            else {
                countSet++;
                if (random.nextInt(2) == 0){
                    maze[line+1][j] = -1;
                    countWall++;
                }
            }
        }
    }
}
