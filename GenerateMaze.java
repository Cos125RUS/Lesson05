import java.util.Random;


public class GenerateMaze {
    public static int[][] maze =
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

    /**
     * Метод создания лабиринта
     * @param height высота лабиринта (
     * @param width ширина лабиринта
     * @param maze лабиринт в виде массива int[][], стенки имеют вес = -1
     * Возращается двумерный массив maze[height][width]
     */
    public static int[][] simple(int height, int width) {
//

        Random random = new Random();
        int[][] maze = new int[height][width];
        for (int i = 0; i < width; i++) {
            maze[0][i] = -1;
            maze[height - 1][i] = -1;
        }
        for (int i = 1; i < height - 1; i++) {
            maze[i][0] = -1;
            maze[i][width - 1] = -1;
        }
        for (int i = 1; i < width - 1; i++)
            for (int j = 0; j < height - 1; j++) {
                int r = random.nextInt(4);
                if (r == 0)
                    maze[i][j] = -1;
            }

        return maze;
    }
}
