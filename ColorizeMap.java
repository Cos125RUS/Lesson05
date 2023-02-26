import java.util.LinkedList;
import java.util.Queue;

public class ColorizeMap {
    private int [][] weights;
    int height;
    int width;

    public ColorizeMap(){
    }

    public ColorizeMap(int[][] map){
        set(map);
    }

    public void set(int[][] map){
        height = map.length;
        width = map[0].length;
        weights = new int[height][width];
        // копирую массив
        for(int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                weights[i][j] = map[i][j];
            }
        }
}

    /**
     * Расстановка весов в клетках лабиринта не занятых стенками и имеющих путь от точки startPoint
     * вес увеличивается на 1 при каждом шаге от точки startPiont
     * @param map лабиринт в виде массива int[][], стенки имеют вес = -1
     * @param startPoint точка старта, вес  = 1
     * @param return возвращает массисв int[][] того же размера, что и входной
     */
    public int[][] colorize(Point2D startPoint){
            Queue<Point2D> fifo = new LinkedList<>();
            fifo.add(startPoint);

            // вес startPoint = 1    
            int weight = 1;

            weights[startPoint.x][startPoint.y] = weight;
    
            while (fifo.size() != 0) {
                Point2D tmp = fifo.poll();
                weight = weights[tmp.x][tmp.y] + 1;
                if ((tmp.x+1 < height) && (weights[tmp.x+1][tmp.y] == 0)) {
                    weights[tmp.x+1][tmp.y] = weight;
                    fifo.add(new Point2D(tmp.x+1, tmp.y));
                }
                if ((tmp.y+1 < width) && (weights[tmp.x][tmp.y+1] == 0)) {
                    weights[tmp.x][tmp.y+1] = weight;
                    fifo.add(new Point2D(tmp.x, tmp.y+1));
                }
                if ((tmp.x-1 >= 0) && (weights[tmp.x-1][tmp.y] == 0)) {
                    weights[tmp.x-1][tmp.y] = weight;
                    fifo.add(new Point2D(tmp.x-1, tmp.y));
                }
                if ((tmp.y-1 >= 0) && (weights[tmp.x][tmp.y-1] == 0)) {
                    weights[tmp.x][tmp.y-1] = weight;
                    fifo.add(new Point2D(tmp.x, tmp.y-1));
                }
            }
            return weights;
    }

// =============================================================================
// функции для тестирования

public static void test(){
    int height = 20;
    int width = 20;
    GenerateMaze maze = new GenerateMaze(height, width);
    int[][] labirint = maze.simple();
    printMap(labirint);

    Point2D startPoint = new Point2D(1, 1);
    Point2D endPoint = new Point2D(height-2, width-2);

    ColorizeMap cmap = new ColorizeMap();
    cmap.set(labirint);
    int[][] weights = cmap.colorize(startPoint);

    Point2D[] way = findPath(weights, startPoint, endPoint);

    if (way.length != 0) printPath(labirint, way);
    else printNoWay();
}

    public static void printMap(int[][] map){
        System.out.println("Labirint:");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] == -1 ? "\033[31m\u2593\u2593":"  ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static Point2D[] findPath(int[][]weights, Point2D start, Point2D stop){
        Integer pathLength = weights[stop.x][stop.y];
        // если точка недостижима (вес = 0) или это стенка (вес = -1), то возвращаю массив нулевой длины
        if (pathLength < 1) return new Point2D[]{};
        
        Point2D[] path = new Point2D[pathLength+1];
        Integer n = pathLength;
        Point2D now = stop;
        path[n] = now;
        for (int k = 0; k < pathLength; k++){
            if (weights[now.x+1][now.y] < n && weights[now.x+1][now.y] != -1) {
                n = weights[now.x+1][now.y];
                now = new Point2D(now.x+1, now.y);
                path[n] = now;
                continue;
            }
            if (weights[now.x-1][now.y] < n && weights[now.x-1][now.y] != -1) {
                n = weights[now.x-1][now.y];
                now = new Point2D(now.x-1, now.y);
                path[n] = now;
                continue;
            }
            if (weights[now.x][now.y+1] < n && weights[now.x][now.y+1] != -1) {
                n = weights[now.x][now.y+1];
                now = new Point2D(now.x, now.y+1);
                path[n] = now;
                continue;
            }
            if (weights[now.x][now.y-1] < n && weights[now.x][now.y-1] != -1) {
                n = weights[now.x][now.y-1];
                now = new Point2D(now.x, now.y-1);
                path[n] = now;
                continue;
            }
        }
        return path;
    }


    public static void printPath(int[][] map, Point2D[] path){
        System.out.println("Path:");
        map[path[1].x][path[1].y] = 2;
        map[path[path.length-1].x][path[path.length-1].y] = 3;
        for (int i = 2; i < path.length-1; i++) {
            map[path[i].x][path[i].y] = 1;//i;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++){
                if (map[i][j] == -1) System.out.print("\033[31m\u2593\u2593");
                if (map[i][j] == 0) System.out.print("  ");
                if (map[i][j] == 1) System.out.print("\033[32m\u2591\u2591");
                if (map[i][j] == 2) System.out.print("\033[32m\uC6C3");
                if (map[i][j] == 3) System.out.print("\033[32m\u2705");

            }
            System.out.println();
        }
    }


    public static void printNoWay(){
        System.out.println("""
            \033[33m
            ███╗░░██╗░█████╗░  ░██╗░░░░░░░██╗░█████╗░██╗░░░██╗██╗
            ████╗░██║██╔══██╗  ░██║░░██╗░░██║██╔══██╗╚██╗░██╔╝██║
            ██╔██╗██║██║░░██║  ░╚██╗████╗██╔╝███████║░╚████╔╝░██║
            ██║╚████║██║░░██║  ░░████╔═████║░██╔══██║░░╚██╔╝░░╚═╝
            ██║░╚███║╚█████╔╝  ░░╚██╔╝░╚██╔╝░██║░░██║░░░██║░░░██╗
            ╚═╝░░╚══╝░╚════╝░  ░░░╚═╝░░░╚═╝░░╚═╝░░╚═╝░░░╚═╝░░░╚═╝
            """);
    }


}






