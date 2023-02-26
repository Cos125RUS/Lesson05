import java.util.LinkedList;
import java.util.Queue;

public class Findway {
    public static Point2D[] findWay(int[][] map, Point2D startPoint, Point2D endPoint){
        Point2D[] answer = new Point2D[map[endPoint.x][endPoint.y] +1];
        Queue<Point2D> queue = new LinkedList<Point2D>();
        queue.add(endPoint);
        Point2D point = queue.element();
        int count = 0;
        while (queue.isEmpty() == false){
            point = queue.element();
            if(map[point.x - 1][point.y] > 0){
                if(map[point.x - 1][point.y] < map[point.x][point.y]){
                    queue.add(new Point2D(point.x - 1, point.y));
                    answer[count] = new Point2D(point.x - 1, point.y);
                    count++;
                }
            }
            if(map[point.x][point.y + 1] > 0){
                if(map[point.x][point.y + 1] < map[point.x][point.y]){
                    queue.add(new Point2D(point.x, point.y + 1));
                    answer[count] = new Point2D(point.x, point.y + 1);
                    count++;
                }
            }
            if(map[point.x + 1][point.y] > 0){
                if(map[point.x + 1][point.y] < map[point.x][point.y]){
                    queue.add(new Point2D(point.x + 1, point.y));
                    answer[count] = new Point2D(point.x + 1, point.y);
                    count++;
                }
            }
            if(map[point.x][point.y - 1] > 0){
                if(map[point.x][point.y - 1] < map[point.x][point.y]){
                    queue.add(new Point2D(point.x, point.y - 1));
                    answer[count] = new Point2D(point.x, point.y - 1);
                    count++;
                }
            }
            queue.remove();
        }
        return answer;
    }
}