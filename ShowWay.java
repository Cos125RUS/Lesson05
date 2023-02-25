public class ShowWay {
    
    // метод который присваивает всем ячейкам map, которые являются путем следования значение =-2 
    public static void showWay(int[][] map, Point2D[] point){
        for (int i = 0; i < point.length; i++){
            map[point[i].x][point[i].y] = -2;
        }
    }
}