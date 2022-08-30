package BOJ2435;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2435 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int K;
    static int[] preSum;
    public static int solve(int[] preSum, int k) {
        int sum = Integer.MIN_VALUE;
        for(int i = k; i < N + 1; i++) {
            int tmp = preSum[i] - preSum[i-k];
            sum = Math.max(sum, tmp);
        }

        return sum;
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        preSum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            preSum[i] = preSum[i-1] + tmp; //미리 합 구해두기
        }

        bw.write(solve(preSum, K) + "");
        bw.flush();
        bw.close();
    }
}
