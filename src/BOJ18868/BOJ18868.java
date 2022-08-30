package BOJ18868;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ18868 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int M;
    static int N;
    static int[][] universe;
    static int result;

    public static boolean multiverseCheck(int index, int index2) {
        boolean ch = true;
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                if (universe[index][i] > universe[index][j]) {
                    if (!(universe[index2][i] > universe[index2][j])) {
                        return false;
                    }
                } else if (universe[index][i] < universe[index][j]) {
                    if (!(universe[index2][i] < universe[index2][j])) {
                        return false;
                    }
                } else {
                    if (!(universe[index2][i] == universe[index2][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void solve(int index) {
        if(index > N) {
            return;
        }
        for (int i = index + 1; i < N; i++) {
            if(multiverseCheck(index,i)) {
                result++;
            }
        }

        solve(index+1);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        universe = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                universe[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0);

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
