public class Findway {
    public static Point2D[] findWay(int[][] map, Point2D startPoint, Point2D endPoint){
        Point2D[] answer = new Point2D[map[endPoint.x][endPoint.y]];
        Point2D point = endPoint;
        int count = 0;
        while (!point.equals(startPoint)){
            if(map[point.x - 1][point.y] > 0){
                if(map[point.x - 1][point.y] < map[point.x][point.y]){
                    point = new Point2D(point.x - 1, point.y);
                    answer[count] = point;
                    count++;
                    continue;
                }
            }
            if(map[point.x][point.y + 1] > 0){
                if(map[point.x][point.y + 1] < map[point.x][point.y]){
                    point = new Point2D(point.x, point.y + 1);
                    answer[count] = point;
                    count++;
                    continue;
                }
            }
            if(map[point.x + 1][point.y] > 0){
                if(map[point.x + 1][point.y] < map[point.x][point.y]){
                    point = new Point2D(point.x + 1, point.y);
                    answer[count] = point;
                    count++;
                    continue;
                }
            }
            if(map[point.x][point.y - 1] > 0){
                if(map[point.x][point.y - 1] < map[point.x][point.y]){
                    point = new Point2D(point.x, point.y - 1);
                    answer[count] = point;
                    count++;
                    continue;
                }
            }
        }
        answer[count] = startPoint;
        return answer;
    }
}