public class Example01 {
    public static void main(String[] args) {
        int height = 10, width = 10;
//        int maze[][] = GenerateMaze.maze; // Лабиринт написанный руками
        int maze[][] = GenerateMaze.simple(height, width); // Лабиринт с рандомными стенками
        GenerateMaze.euler(height, width);


    }
}
