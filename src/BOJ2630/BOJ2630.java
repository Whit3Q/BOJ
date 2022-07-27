package BOJ2630;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] field;
    static int white;
    static int black;

    public static void solve(int[][] field, int y, int x, int size) {

        boolean ch = true;
        for (int ty = y; ty < y + size; ty++) {
            for (int tx = x; tx < x + size; tx++) {
                if (field[y][x] != field[ty][tx]) {
                    ch = false;
                    break;
                }
            }
            if (!ch) {
                break;
            }
        }

        if (ch) {
            if (field[y][x] == 1) {
                black++;
            } else {
                white++;
            }
        } else {
            int nextSize = size / 2;
            solve(field, y, x, nextSize);
            solve(field, y, x + nextSize, nextSize);
            solve(field, y + nextSize, x, nextSize);
            solve(field, y + nextSize, x + nextSize, nextSize);
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        field = new int[N][N];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                field[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        solve(field, 0, 0, N);

        bw.write(white + "");
        bw.newLine();
        bw.write(black + "");
        bw.newLine();

        bw.flush();
        bw.close();
    }
}



