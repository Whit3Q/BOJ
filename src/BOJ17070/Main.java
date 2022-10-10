package BOJ17070;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int Y;
    static int X;

    static ArrayList<Integer>[] dy;
    static ArrayList<Integer>[] dx;

    static int[][] field;



    public static void main(String[] args) throws IOException{
        makeDyDx();

        Y = X =Integer.parseInt(br.readLine());
        field = new int[Y][X];

        for(int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < X; x++) {
                field[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        if(field[Y-1][X-1] != 1) {
            result = bfs();
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    public static void makeDyDx() {
        dy = new ArrayList[3];
        for(int i = 0; i < 3; i++) {
            dy[i] = new ArrayList<>();
        }
        dx = new ArrayList[3];
        for(int i = 0; i < 3; i++) {
            dx[i] = new ArrayList<>();
        }

        // 0은 가로
        dy[0].add(0);
        dy[0].add(0);
        dy[0].add(1);


        dx[0].add(1);
        dx[0].add(0);
        dx[0].add(1);


        // 1은 세로
        dy[1].add(0);
        dy[1].add(1);
        dy[1].add(1);

        dx[1].add(0);
        dx[1].add(0);
        dx[1].add(1);


        //2는 대각
        dy[2].add(0);
        dy[2].add(1);
        dy[2].add(1);

        dx[2].add(1);
        dx[2].add(0);
        dx[2].add(1);
    }

    public static int bfs() {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0,0,0,1,0));
        int result = 0;

        int count = 0;
        while(!que.isEmpty()) {

            int size = que.size();
            count++;
            while(size-- > 0) {
                Point now = que.remove();

                for(int i = 0; i < 3; i++) {
                    int newY = now.y2 + dy[now.d].get(i);
                    int newX = now.x2 + dx[now.d].get(i);

                    if(dy[now.d].get(i) == 0 && dx[now.d].get(i) == 0) {
                        continue;
                    }

                    if(checkMoving(i, newY, newX, now.d)) {
                        if(newY == Y -1 && newX == X -1) {
                            result++;
                            continue;
                        }

                        que.add(new Point(now.y2, now.x2, newY, newX, i));
                    }
                }

            }
        }
        return result;
    }


    public static boolean checkMoving(int index, int newY, int newX, int nowd) {

        if(newY < 0 || newX < 0 || newY > Y -1 || newX > X - 1) {
            return false;
        }

        if(field[newY][newX] == 1) {
            return false;
        }

        if(dx[nowd].get(index) == 1 && dy[nowd].get(index) == 1) {
            if(newX -1 < 0 || newY - 1 < 0) {
                return false;
            }

            if(field[newY][newX - 1] == 1 || field[newY -1][newX] == 1) {
                return false;
            }
        }

        return true;
    }


    static class Point {
        int y1;
        int x1;
        int y2;
        int x2;
        int d;
        public Point(int y1, int x1, int y2, int x2, int d) {
            this.y1 = y1;
            this.x1 = x1;

            this.y2 = y2;
            this.x2 = x2;

            this.d = d;
        }
    }
}
