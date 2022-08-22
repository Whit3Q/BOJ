package BOJ2583;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2583 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int M;
    static int N;
    static int K;
    static int[][] field;
    static int[] dy = {0,0, -1, 1};
    static int[] dx = {-1, 1,0,0};

    public static int dfs(int y, int x) {

        int result = 0;
        field[y][x] = 1;

        for(int i = 0; i < 4; i++ ) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newY < 0 || newY > M-1 || newX < 0 || newX > N - 1 || field[newY][newX] == 1) {
                continue;
            }

            result += dfs(newY, newX) + 1;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        field = new int[M][N];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            fullPoint(field, start, end);
        }
        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int y = 0; y < M; y++) {
            for(int x = 0; x < N; x++) {
                if(field[y][x] == 0) {
                    count++;
                    result.add(dfs(y, x)+1);
                }
            }
        }
        Collections.sort(result);

        bw.write(count+"\n");
        for(int i : result) {
            bw.write(i+" ");
        }
        bw.flush();
        bw.close();
    }

    public static void fullPoint(int[][] field ,Point start ,Point end) {

        for(int y = start.y; y < end.y; y++) {
            for(int x = start.x; x < end.x; x++) {
                field[y][x] = 1;
//                System.out.println(y+" " + x);
            }
        }

    }

    static class Point {
        int y;
        int x;

        public Point(int x, int y) {
            this.y = y;
            this.x = x;
        }
    }

}
