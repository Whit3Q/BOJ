package BOJ1965;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1965 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] dp = new int[1000][1000];

    public static int solve(int[] list, int index, int preIndex) {
        if(index >= N) {
            return 0;
        }
        if(dp[index][preIndex] != 0) {
            return dp[index][preIndex];
        }

        if(list[index] > list[preIndex]) {
            dp[index][preIndex] = Math.max(dp[index][preIndex], Math.max(solve(list, index+1,index) + 1, solve(list, index+1, preIndex)));
            return dp[index][preIndex];
        } else {
            return solve(list, index + 1, preIndex);
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        if(N == 1) {
            bw.write("0");
        } else {
            int[] list = new int[N];
            for(int i = 0; i < N; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            int maxResult = 0;
            for(int i = 0; i < N-1; i++) {
                maxResult = Math.max(maxResult, solve(list, i+1,i) + 1);
            }
            bw.write(maxResult+"");
        }

        bw.flush();
        bw.close();
    }
}
