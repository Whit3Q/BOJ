package BOJ11066;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11066 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T;
    static int N;
    static int[] list;
    static int[] preSum;
    static int[][] dp;

    public static int solve(int start, int end) {
        if (start == end) {
            dp[start][end] = 0;
            return dp[start][end];
        }
        if (end - start == 1) {
            dp[start][end] = list[start] + list[end];
            return dp[start][end];
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        int num = Integer.MAX_VALUE;
        for (int i = 0; i < end-start; i++) {
            num = Math.min(num, solve(start, start + i) + solve(start + i + 1, end));
        }

        dp[start][end] = num + (preSum[end+1] - preSum[start]);
        return dp[start][end];
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            list = new int[N];
            preSum = new int[N + 1];
            dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                list[i] = Integer.parseInt(st.nextToken());
                preSum[i+1] = preSum[i + 1 - 1] + list[i];
            }

//            bw.write((list[0]+solve(0)) + "");
            bw.write(solve(0,N-1)+"");
            bw.newLine();
        }

        bw.flush();
        bw.close();

    }
}
