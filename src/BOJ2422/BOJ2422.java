package BOJ2422;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2422 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static int result;
    static boolean[][] memory;


    public static void solve() {
        for(int i = 1; i <= N; i++) {
            for(int j = i+1; j <= N; j++) {
                for(int k = j+1; k <= N; k++) {
                    if(memory[i][j] || memory[i][k] || memory[j][k]) continue;
                    result++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memory = new boolean[N+1][N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            memory[a][b] = true;
            memory[b][a] = true;
        }

        solve();

        bw.write(Math.max(1,result)+"");
        bw.flush();
        bw.close();
    }
}
