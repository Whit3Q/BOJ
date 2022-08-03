package BOJ1309;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1309 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int MOD = 9901;


    public static int solve() throws IOException{
        int num2 = 0;
        int num = 1;
        int now = 3;
        for (int i = 2; i < N+1; i++) {
            int tmp = now;
            now = (((now * 2) % MOD) + (num % MOD)) % MOD;
            num = tmp;
            bw.write(now+"");
            bw.newLine();
        }

        return now;
    }

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        solve();
//        bw.write(solve()+"");
        bw.flush();
        bw.close();
    }
}
