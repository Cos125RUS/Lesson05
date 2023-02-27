public class OutputMap {
    public static void main(String[] args) {
        int[][] map =  {{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
        {-1, 0, -1, -1, -1, -1, 0, 0, 0, -1},
        {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
        {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
        {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
        {-1, 0, -1, -1, -1, -1, -1, -1, 0, -1},
        {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};;
        printMap(map);
    }

    public static void printMap(int[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    System.out.print(" \033[30m \033[0m ");
                } else if (map[i][j] == 1) {
                    System.out.printf(" \033[32m" + map[i][j] + "\033[0m ");
                } else if (map[i][j] >= 10) {
                    System.out.printf("\033[33m" + map[i][j] + "\033[0m ");
                } else if (map[i][j] > 0) {
                    System.out.printf(" \033[33m" + map[i][j] + "\033[0m ");
                } else if (map[i][j] == -2) {
                    System.out.printf("\033[34m" + " "+ "\u2580" + " "+ "\033[0m");
                } else if (map[i][j] == -3) {
                    System.out.printf("\033[32m" + " "+ "\u2593" + " "+ "\033[0m");
                } else if (map[i][j] == -4) {
                    System.out.printf("\033[31m" + " "+ "\u2593" + " "+ "\033[0m");
                } else {
                    System.out.printf("\u2588" + "\u2588"+ "\u2588");
                }
            }
            System.out.println();
        }


    }
}
