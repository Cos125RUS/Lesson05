public class Example01 {
    public static void main(String[] args) {
        int height = 10, width = 10;
//        StaticMaze maze = new StaticMaze();
//        maze.staticMaze(); // Лабиринт написанный руками
        GenerateMaze maze = new GenerateMaze(height, width);
        maze.simple(); // Лабиринт с рандомными стенками
//        maze.euler(); // Тест Эйлера


    }
}
