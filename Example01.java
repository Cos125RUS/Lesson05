
public class Example01 {
    public static void main(String[] args) {
        int height = 10, width = 10;
//        StaticMaze map = new StaticMaze();
//        map.staticMaze(); // Лабиринт написанный руками
        GenerateMaze map = new GenerateMaze(height, width);
//        map.simple(); // Лабиринт с рандомными стенками
        map.euler(); // Тест Эйлера
        OutputMap.printMap(map.maze);
        ColorizeMap cmap = new ColorizeMap();
        cmap.set(map.maze);
        Point2D startPoint = new Point2D(1,1);
        Point2D endPoint = new Point2D(1,1);
        startPoint.notWallPoint(1,9, map.maze);
        endPoint.notWallPoint(1,9, map.maze);
        map.maze = cmap.colorize(startPoint);
        System.out.println("\n");
        OutputMap.printMap(map.maze);
        Point2D[] way = Findway.findWay(map.maze, startPoint, endPoint);
        ShowWay.showWay(map.maze, way);
        System.out.println("\n");
        OutputMap.printMap(map.maze);
    }
}
