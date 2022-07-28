package BOJ11401;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11401 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long[] inverse = new long[4000001];
    static long[] factorial = new long[4000001];
    //    static int[] factorial;
    static int N;
    static int M;
    static long mod = 1000000007;

    public static long pow(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }

        long tmp = 1;
        tmp *= pow(A, B / 2, C);

        if (B % 2 != 0) {
            return (tmp * tmp % C) * A % C;
        } else {
            return tmp * tmp % C;
        }
    }

    public static long factorial(int n) {

        if (factorial[4000000] == 0) {
            factorialInit();
        }

        return factorial[n];
    }

    private static void factorialInit() {
        factorial[1] = 1;
        for (int i = 2; i < 4000001; i++) {
            factorial[i] = (factorial[i - 1] * i) % mod;
        }
    }

    private static void inverseInit() {
        inverse[4000000] = pow(factorial(4000000), mod - 2, mod);
        for (int i = 4000000 - 1; i > 0; i--) {
            inverse[i] = (inverse[i + 1] * (i + 1)) % mod;
        }
    }


    public static long solve(int N, int M) {

        return ((factorial(N) * inverse[M])%mod * inverse[N - M]) % mod;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        if(N == M || N ==0 || M == 0) {
            bw.write("1");
        } else {
            factorialInit();
            inverseInit();

            bw.write(solve(N, M) + "");
        }

        bw.flush();
        bw.close();
    }
}
