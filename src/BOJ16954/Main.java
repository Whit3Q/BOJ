package BOJ16954;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int Y = 8 , X = 8;
    static int[] dy = {0, 0, 1, -1, 0, 1, -1, -1, 1};
    static int[] dx = {1, -1, 0, 0, 0, 1, 1, -1, -1};

    static char[][] field;


    public static void main(String[] args) throws IOException {
	/*
........
........
........
........
........
........
........
........
	 */
//1
        Deque<Point> walls = new ArrayDeque<>();
        field = new char[Y][X];
        for(int y = 0; y < Y; y++) {
            String line = br.readLine();
            for(int x = 0; x < X; x++) {
                char tmp = line.charAt(x);
                field[y][x] = tmp;
                if(tmp == '#') {
                    walls.add(new Point(y, x));
                }
            }
        }

        if(bfs(walls)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean bfs(Deque<Point> walls) {
        boolean check = false;
        Point start = new Point(7, 0);
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(start);

        int count = 0;
        while(!queue.isEmpty()) {
            count++;
            int size = queue.size();


            while(size-- > 0) {
                Point now = queue.remove();
                if(field[now.y][now.x] == '#') { //이동했는데 돌이 떨어졌을 경우
                    continue;
                }

                for(int i = 0; i < 9; i++) { //욱제의 이동
                    int newY = now.y + dy[i];
                    int newX = now.x + dx[i];

                    if(newY < 0 || newX < 0 || newY > Y -1 || newX > X - 1 || field[newY][newX] == '#') { //제한사항
                        continue;
                    }

                    if(newY == 0 && newX == 7) { //목표에 도달 가능한 경우
                        return true;
                    }

                    queue.add(new Point(newY, newX));

                }

            }
            int wallSize = walls.size();
            for(int i = 0; i < wallSize; i++) { //벽 순회해서 돌기
                Point wall = walls.pollLast();
                int newY = wall.y + 1;
                int newX = wall.x;

                if(newY > 7) {
                    field[wall.y][wall.x] = '.';
                    continue;
                }

                field[wall.y][wall.x] = '.';
                field[newY][newX] = '#';
                walls.addFirst(new Point(newY, newX));
            }




        }


        return check;
    }

    public static class Point {
        int x;
        int y;
        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
