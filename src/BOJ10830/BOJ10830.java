package BOJ10830;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ10830 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] matrix;
    static int N;
    static long B;
    static int MOD = 1000;

    public static int[][] mul(int[][] matrix, int[][] matrix2) {
        int[][] result = new int[N][N];
        for(int y = 0; y < matrix.length; y++) {
            for(int x = 0; x < matrix[0].length; x++) {
                for(int i = 0; i < matrix.length; i++) {
                    result[y][x] += (matrix[i][x] * matrix2[y][i]) % MOD;
                }
                result[y][x] %= MOD;
            }
        }

        return result;
    }

    public static int[][] pow(int[][] matrix, long B) {
        if(B == 1) {
            for(int y = 0; y < N; y++) {
                for(int x = 0; x < N; x++) {
                    matrix[y][x] %= MOD;
                }
            }

            return matrix;
        }

        if(B % 2 != 0) {
            int[][] tmp = pow(matrix, B/2);
            return mul(mul(tmp,tmp),matrix);
        } else {
            int[][] tmp = pow(matrix,B/2);
            return mul(tmp, tmp);
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        matrix = new int[N][N];

        for(int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++) {
                matrix[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = pow(matrix, B);


        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                bw.write(result[y][x]+" ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

}
