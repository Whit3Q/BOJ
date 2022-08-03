package BOJ1309;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1309_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int MOD = 9901;
    static int[][] field;

    public static int solve(){
        for(int i = 1; i < N+1; i++) {
            field[0][i] = (field[0][i-1] + field[1][i-1] + field[2][i-1])%MOD;
            field[1][i] = (field[0][i-1] + field[2][i-1])%MOD;
            field[2][i] = (field[0][i-1] + field[1][i-1])%MOD;
        }

        return field[0][N];
    }

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        field = new int[3][N+1];
        field[0][0] = 1;
        field[1][0] = 1;
        field[2][0] = 1;

        bw.write(solve()+"");
        bw.flush();
        bw.close();
    }
}
