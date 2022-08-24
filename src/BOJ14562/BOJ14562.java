package BOJ14562;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int C;
    static int S;
    static int T;

    public static int dfs(int S, int T, int count) {
        if (S > T) {
            return Integer.MAX_VALUE;
        }

        if (S + 1 == T || S * 2 == T + 3) {
            return count + 1;
        }
        int result = Integer.MAX_VALUE;
        result = Math.min(dfs(S + 1, T, count + 1),
                dfs(S * 2, T + 3, count + 1));

        return result;
    }

    public static void main(String[] args) throws IOException {
        C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            bw.write(dfs(S, T, 0) + "\n");
        }

        bw.flush();
        bw.close();
    }

}
