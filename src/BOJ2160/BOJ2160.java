package BOJ2160;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2160 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][][] field;

    public static int check(int[][][] field, int n, int m) {
        int[][] num1 = field[n];
        int[][] num2 = field[m];
        int count = 0;
        for(int y = 0; y < 5; y++ ) {
            for(int x = 0; x < 7; x++ ) {
                if(num1[y][x] != num2[y][x]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        field = new int[N][5][7];

        for(int i = 0; i < N; i++) {
            for(int y = 0; y < 5; y++) {
                String line = br.readLine();
                for(int x = 0; x <7; x++) {
                    char tmp = line.charAt(x);
                    int num = 0;
                    if (tmp == 'X') {
                        num = 1;
                    }
                    field[i][y][x] = num;
                }
            }

        }


        int[] result = new int[2];
        int target = Integer.MAX_VALUE;
        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                int tmp = check(field, i, j);
                if(target > tmp) {
                    result[0] = i+1;
                    result[1] = j+1;
                    target = tmp;
                }
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
