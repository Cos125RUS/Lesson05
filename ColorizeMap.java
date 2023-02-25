import java.util.LinkedList;
import java.util.Queue;

public class ColorizeMap {
    /**
     * Расстановка весов клеток лобиринта увеличивающихся на 1 при каждом шаге от точки startPiont
     * @param map лабиринт в виде массива int[][], стенки имеют вес = -1
     * @param startPoint точка старта, вес  = 1
     * @param stop
     */
    public static void colorize(int[][] map, Point2D startPoint, Point2D stop){
            Queue<Point2D> fifo = new LinkedList<>();
            fifo.add(startPoint);
            map[startPoint.x][startPoint.y] = 1;
    
            while (fifo.size() != 0) {
                Point2D tmp = fifo.poll();
                Integer m = map[tmp.x][tmp.y] + 1;
                if (map[tmp.x+1][tmp.y] == 0) {
                    map[tmp.x+1][tmp.y] = m;
                    fifo.add(new Point2D(tmp.x+1, tmp.y));
                }
                if (map[tmp.x][tmp.y+1] == 0) {
                    map[tmp.x][tmp.y+1] = m;
                    fifo.add(new Point2D(tmp.x, tmp.y+1));
                }
                if (map[tmp.x-1][tmp.y] == 0) {
                    map[tmp.x-1][tmp.y] = m;
                    fifo.add(new Point2D(tmp.x-1, tmp.y));
                }
                if (map[tmp.x][tmp.y-1] == 0) {
                    map[tmp.x][tmp.y-1] = m;
                    fifo.add(new Point2D(tmp.x, tmp.y-1));
                }
            }
    }

}

