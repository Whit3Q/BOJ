package BOJ13410;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13410 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int K;

    public static int solve(int n, int m) {
        int[] field = new int[m+1];
        int maxNum = 0;

        for (int i = 1; i <= m; i++) {
            int tmp = n * i;
            int num = 0;
            while (tmp > 0) {
                num *= 10;
                num += tmp % 10;
                tmp /= 10;
            }
            field[i] = num;
//            maxNum = Math.max(maxNum, num);
        }
        Arrays.sort(field);

        return field[m];
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(solve(N, K));
    }
}
