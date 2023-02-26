public class Example01 {
    public static void main(String[] args) {
        int height = 10, width = 10;
        GenerateMaze maze = new GenerateMaze(height, width);
//        maze.staticMaze(); // Лабиринт написанный руками
        maze.simple(); // Лабиринт с рандомными стенками
//        maze.euler(); // Тест Эйлера


    }
}
