package BOJ2740;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2740 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] field1;
    static int[][] field2;
    static int[][] result;


    public static void solve(int[][] field1, int[][] field2) {

        for(int y = 0; y < field1.length; y++) {
            for(int x = 0; x < field2[0].length; x++) {

                int tmp = 0;
                for(int i = 0; i < field1[0].length; i++) {
                    tmp += field1[y][i] * field2[i][x];
                }

                result[y][x] = tmp;

            }
        }

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field1 = new int[N][M];

        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < M; x++) {
                field1[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field2 = new int[N][M];

        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < M; x++) {
                field2[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        result = new int[field1.length][field2[0].length];

        solve(field1, field2);

        for(int y = 0; y < result.length; y++) {
            for(int x= 0; x < result[0].length; x++) {
                bw.write(result[y][x]+" ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
