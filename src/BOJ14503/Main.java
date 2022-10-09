package BOJ14503;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int Y;
    static int X;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] dd = {3, 0, 1, 2};
    static int[] bb = {2, 3, 0, 1};

    static int[][] field;
    static int[][] memory;

    public static int dfs(Point nowPoint, int count) {
        int tmpCount = count;
        if(memory[nowPoint.y][nowPoint.x] == 0) { // 전진으로 왔을 때
            memory[nowPoint.y][nowPoint.x] = 1;
            tmpCount++;
        }
        int newD = nowPoint.d;
        int newY = nowPoint.y;
        int newX = nowPoint.x;
        boolean check = false;
        for(int i = 0; i < 4; i++) {
            newD = dd[newD];
            newY = nowPoint.y + dy[newD];
            newX = nowPoint.x + dx[newD];
            if(field[newY][newX] != 1 && memory[newY][newX] == 0) { //길 찾음
                check = true;
                break;
            }
        }

        if(!check && newD == nowPoint.d) { //길 못찾음 후진
            newY = nowPoint.y + dy[bb[newD]];
            newX = nowPoint.x + dx[bb[newD]];
            if(field[newY][newX] == 1) {
                return tmpCount;
            }
        }

        return dfs(new Point(newY, newX, newD),  tmpCount);
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Point startPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        field = new int[Y][X];
        memory = new int[Y][X];

        for(int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < X; x++) {
                field[y][x] = Integer.parseInt(st.nextToken());
                if(field[y][x] == 1) {
                    memory[y][x] = 1;
                }
            }
        }

        System.out.println(dfs(startPoint, 0));

    }

    static class Point {
        int y;
        int x;
        int d;

        public Point (int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
}
