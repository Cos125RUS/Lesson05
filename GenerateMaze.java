import java.util.Random;


public class GenerateMaze {
    int height = 10;
    int width = 10;
    int[][] maze;
    static Random random;

    /**
     * Конструктор класса
     * @param height высота лабиринта
     * @param width ширина лабиринта
     * @param maze лабиринт в виде массива int[][]
     */
    public GenerateMaze(int height, int width) {
        this.height = height;
        this.width = width;
        this.maze = new int[height][width];
        this.random = new Random();
    }

    /**
     * Генерация лабиринта простым рандомом
     * @param maze лабиринт в виде массива int[height][width], стенки имеют вес = -1
     */
    public int[][] simple() {
        boards(maze, -1);

        for (int i = 1; i < height - 1; i++)
            for (int j = 1; j < width - 1; j++) {
                int r = random.nextInt(4);
                if (r == 0)
                    maze[i][j] = -1;
            }

        return maze;
    }


    /**
     * Метод создания лабиринта алгоритмом Эйлера
     * @param maze лабиринт в виде массива int[height][width], стенки имеют вес = -1
     */
    public void euler(){
        int[][] sets = new int[height][width];
        boards(maze, -1);
        boards(sets, 1);

        for (int i = 1; i < height-1; i+=2){
            fillSetLine(sets, width-1, i);
            buildWall(sets,width-1, i);
            System.out.println();
        }


//        return maze;
    }



//    Закрытые методы класса:



    /**
     * Метод создания границ лабиринта
     */
    private void boards(int[][] map, int wall){
        for (int i = 0; i < width; i++) {
            map[0][i] = wall;
            map[height - 1][i] = wall;
        }
        for (int i = 1; i < height - 1; i++) {
            map[i][0] = wall;
            map[i][width - 1] = wall;
        }
    }

    private void fillSetLine(int[][] sets, int width, int line) {
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

    private void buildWall(int[][] sets, int width, int line){
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

        for (int j = 2;j < width-2; j++)
            if (maze[line][j] == -1 && (maze[line+1][j+1] == -1 || maze[line+1][j-1] == -1))
                maze[line+1][j] = -1;
    }
}
