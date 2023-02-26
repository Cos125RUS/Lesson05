public class Example01 {
    public static void main(String[] args) {
        int height = 10, width = 10;
//        StaticMaze map = new StaticMaze();
//        map.staticMaze(); // Лабиринт написанный руками
        GenerateMaze map = new GenerateMaze(height, width);
        map.simple(); // Лабиринт с рандомными стенками
//        map.euler(); // Тест Эйлера

    }
}
