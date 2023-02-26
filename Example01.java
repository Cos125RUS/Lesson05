import java.util.Random;

public class Example01 {
    public static void main(String[] args) {
        Random random = new Random();
        int height = 10, width = 10;
//        StaticMaze map = new StaticMaze();
//        map.staticMaze(); // Лабиринт написанный руками
        GenerateMaze map = new GenerateMaze(height, width);
        map.simple(); // Лабиринт с рандомными стенками
//        map.euler(); // Тест Эйлера
        OutputMap.printMap(map.maze);
        ColorizeMap cmap = new ColorizeMap();
        cmap.set(map.maze);
        Point2D startPoint;
        do {
            //System.out.println("ST");
            startPoint = new Point2D(random.nextInt(1, 9), random.nextInt(1, 9));
            //System.out.println("map["+ startPoint.x + "][" + startPoint.y + "] = " + map.maze[startPoint.x][startPoint.y]);
        } while (!startPoint.isEmpty(map.maze));
        map.maze = cmap.colorize(startPoint);
        System.out.println();
        System.out.println();

        Point2D endPoint;
        do {
            //System.out.println("END");
            endPoint = new Point2D(random.nextInt(1, 9), random.nextInt(1, 9));
            //System.out.println("map["+ endPoint.x + "][" + endPoint.y + "] = " + map.maze[endPoint.x][endPoint.y]);
        } while (!endPoint.isEmpty(map.maze));
        OutputMap.printMap(map.maze);
        Point2D[] way = Findway.findWay(map.maze, startPoint, endPoint);
        ShowWay.showWay(map.maze, way);
        System.out.println();
        System.out.println();
        OutputMap.printMap(map.maze);
    }
}
