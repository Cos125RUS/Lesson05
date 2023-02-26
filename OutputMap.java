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
                    System.out.printf(" \033[31m" + map[i][j] + "\033[0m ");
                } else if (map[i][j] == 1) {
                    System.out.printf(" \033[32m" + map[i][j] + "\033[0m ");
                } else if (map[i][j] >= 10) {
                    System.out.printf("\033[33m" + map[i][j] + "\033[0m ");
                } else if (map[i][j] > 0) {
                    System.out.printf(" \033[33m" + map[i][j] + "\033[0m ");
                } else {
                    System.out.printf(map[i][j] + " ");
                }
            }
            System.out.println();
        }


    }
}
