package BOJ1926;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1926 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int Y;
    static int X;
    static int[][] field;
    static int maxCount = 0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};


    public static int dfs(int y, int x) {
        int result = 0;
        field[y][x] = 0;

        for(int i = 0; i < 4; i++) {
            int newY = y+dy[i];
            int newX = x+dx[i];

            if(newY < 0 || newY > Y - 1 || newX < 0 || newX > X-1 || field[newY][newX] == 0) {
                continue;
            }
            result += dfs(newY, newX) + 1;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        field = new int[Y][X];

        for(int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < X; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        for(int y = 0; y < Y; y++) {
            for(int x =0; x < X; x++) {
                if(field[y][x] == 1) {
                    count++;
                    maxCount = Math.max(dfs(y,x) + 1, maxCount);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxCount);
    }


}
