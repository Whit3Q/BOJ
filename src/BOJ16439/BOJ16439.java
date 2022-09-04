package BOJ16439;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ16439 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] peoples;
    static boolean[] memory;

    public static int sumChicken() {
        int sum = 0;
        for(int i = 0 ; i < N; i++) {
           int tmp = 0;
           for(int j = 0; j < M; j++) {
               if(memory[j]) {
                   tmp = Math.max(tmp, peoples[i][j]);
               }
           }
           sum += tmp;
        }

        return sum;
    }

    public static int solve(int[] peoples, int index, int count) {
        int result = 0;
        if(count == 3) {
            return sumChicken();
        }

        if(index >= M) {
            return 0;
        }

        memory[index] = true;
        result = Math.max(result,solve(peoples, index + 1, count + 1));
        memory[index] = false;
        result = Math.max(result,solve(peoples, index + 1, count));

        return result;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        peoples = new int[N+1][M];
        memory = new boolean[M];

        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                peoples[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(solve(peoples[N], 0, 0)+"");
        bw.flush();
        bw.close();
    }
}
