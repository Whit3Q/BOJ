package BOJF10026;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10026 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] field;
    static int[][] memory;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};


    public static void dfs(int y, int x, int first,boolean check) {
        memory[y][x] = 1;

        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newY < 0 || newX < 0|| newY > N -1 || newX > N -1 || memory[newY][newX] == 1) {
                continue;
            }
            if(check) {
                if(first == 0 && field[newY][newX] != 0) {
                    continue;
                } else if(first != 0 && field[newY][newX] == 0){
                    continue;
                }
            } else {
                if(field[newY][newX] != first) {
                    continue;
                }
            }

            dfs(newY, newX, first, check);
        }

    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        field = new int[N][N];
        memory = new int[N][N];

        for (int y = 0; y < N; y++) {
            String line = br.readLine();
            for (int x = 0; x < N; x++) {
                int tmp = 0;
                char tmpChar = line.charAt(x);
                if (tmpChar == 'R') {
                    tmp = 1;
                } else if (tmpChar == 'G') {
                    tmp = 2;
                }

                field[y][x] = Integer.parseInt(String.valueOf(tmp));
            }
        }

        int count = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (memory[y][x] == 0) {
                    count++;
                    dfs(y, x, field[y][x], false);
                }
            }
        }

        memory = new int[N][N];

        int count2 = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (memory[y][x] == 0) {
                    count2++;
                    dfs(y, x, field[y][x], true);
                }
            }
        }

        bw.write(count + " ");
        bw.write(count2+"");
        bw.flush();
        bw.close();
    }
}
