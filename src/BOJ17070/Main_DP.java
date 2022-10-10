package BOJ17070;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_DP {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int Y;
    static int X;

    static int[][] field;
    static int[][][] dp;

    public static void main(String[] args) throws IOException{
        Y = X = Integer.parseInt(br.readLine());

        field = new int[Y][X];
        dp = new int[Y][X][3];

        for(int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < X; x++) {
                field[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][1][0] = 1;

        for(int y = 0; y < Y; y++) {
            for(int x = 1; x < X; x++) {
                if(dp[y][x][0] > 0) {
                    if(x+1 < X && field[y][x+1] == 0) {
                        dp[y][x+1][0] += dp[y][x][0];
                    }
                    if(y+1 < Y && x + 1 <X && field[y+1][x+1] == 0 && field[y+1][x] == 0 && field[y][x+1] == 0) {
                        dp[y+1][x+1][2] += dp[y][x][0];
                    }
                }

                if(dp[y][x][1] > 0) {
                    if(y+1 < Y && field[y+1][x] == 0) {
                        dp[y+1][x][1] += dp[y][x][1];
                    }
                    if(y+1 < Y && x + 1 <X && field[y+1][x+1] == 0 && field[y+1][x] == 0 && field[y][x+1] == 0) {
                        dp[y+1][x+1][2] += dp[y][x][1];
                    }
                }

                if(dp[y][x][2] > 0) {
                    if(x+1 < X && field[y][x+1] == 0) {
                        dp[y][x+1][0] += dp[y][x][2];
                    }

                    if(y+1 < Y && field[y+1][x] == 0) {
                        dp[y+1][x][1] += dp[y][x][2];
                    }

                    if(y+1 < Y && x + 1 <X && field[y+1][x+1] == 0 && field[y+1][x] == 0 && field[y][x+1] == 0) {
                        dp[y+1][x+1][2] += dp[y][x][2];
                    }
                }
            }
        }

        bw.write((dp[Y-1][X-1][0] + dp[Y-1][X-1][1] + dp[Y-1][X-1][2]) + "");
        bw.flush();
        bw.close();
    }
}
