import java.util.Random;


public class GenerateMaze {
    int height = 10;
    int width = 10;
    int[][] maze;
    static Random random;

    /**
     * Конструктор класса
     *
     * @param height высота лабиринта
     * @param width  ширина лабиринта
     * @param maze   лабиринт в виде массива int[][]
     */
    public GenerateMaze(int height, int width) {
        this.height = height;
        this.width = width;
        this.maze = new int[height][width];
        this.random = new Random();
    }

    /**
     * Генерация лабиринта простым рандомом
     *
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
     *
     * @param maze лабиринт в виде массива int[height][width], стенки имеют вес = -1
     */
    public void euler() {
        int[][] sets = new int[height][width];
        boards(maze, -1);

        for (int i = 1; i < height - 1; i += 2) {
            fillSetLine(i);
            if (i < height - 3)
                buildWall(i);
        }

        for (int i = 2; i < width - 2; i += 2) {
            if (maze[height - 2][i] == -1 && maze[height - 3][i - 1] == -1 && maze[height - 2][i - 2] == -1)
                maze[height - 3][i - 1] = 0;
            if (maze[height - 2][i] == -1)
                i = clearZone(i+1);
        }
    }


//    Закрытые методы класса:


    /**
     * Метод создания границ лабиринта
     */
    private void boards(int[][] map, int wall) {
        for (int i = 0; i < width; i++) {
            map[0][i] = wall;
            map[height - 1][i] = wall;
        }
        for (int i = 1; i < height - 1; i++) {
            map[i][0] = wall;
            map[i][width - 1] = wall;
        }
    }

    private void fillSetLine(int line) {
        for (int j = 2; j < width - 2; j += 2)
            if (maze[line - 1][j] == 0 && maze[line - 1][j + 2] == 0) {
                maze[line][j] = -1;
                maze[line - 1][j] = -1;
                maze[line + 1][j] = -1;
            } else if (random.nextInt(3) == 0) {
                maze[line][j] = -1;
                maze[line + 1][j] = -1;
            }
    }

    private void buildWall(int line) {
        int countWall = 0;
        int countSet = 0;
        for (int j = 2; j < width - 2; j += 2) {
            if (maze[line][j] == -1) {
                if (countSet == countWall)
                    maze[line + 1][j - 1 - random.nextInt(1 + countSet) * 2] = 0;
                countWall = 0;
                countSet = 0;
            } else {
                countSet++;
                maze[line + 1][j] = -1;
                if (random.nextInt(2) == 0) {
                    maze[line + 1][j - 1] = -1;
                    countWall++;
                }
            }
        }
    }

    private int clearZone(int index) {
        int length = 1;
        int wall = 1;

        while (maze[height - 2][index + length] == 0) {
            if (maze[height - 3][index + length] == -1)
                wall++;
            length++;
        }

        if (wall == length)
            maze[height - 3][random.nextInt(index,  index + length)] = 0;

        index += length - 1;

        return index - 1;
    }
}
