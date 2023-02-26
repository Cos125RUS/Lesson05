public class ShowWay {
    
    // метод который присваивает всем ячейкам map, которые являются путем следования значение =-2 
    public static void showWay(int[][] map, Point2D[] point){
        // точка конечная
        map[point[0].x][point[0].y] = -4;     
        for (int i = 1; i < point.length - 1; i++){
            map[point[i].x][point[i].y] = -2;
        }
        // точка начальная
        map[point[point.length - 1].x][point[point.length - 1].y] = -3; 
    }
}