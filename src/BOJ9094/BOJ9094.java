package BOJ9094;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ9094 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T;
    static int N;
    static int M;
    public static int solve(int n, int m) {
        int result = 0;

        for(int a = 1; a < n; a++) {
            for(int b = a + 1; b < n; b++) {
                int tmp1 = (a*a) + (b*b) + m;
                int tmp2 = a*b;
                if(tmp1 % tmp2 == 0) {
                    result++;
                }
            }
        }


        return result;
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            bw.write(solve(N,M) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
