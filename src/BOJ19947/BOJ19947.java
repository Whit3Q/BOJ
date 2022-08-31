package BOJ19947;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ19947 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static double H;
    static int Y;
    static int[][] field;
    public static int solve(double h, int y) {
        if(y == 0) {
            return (int) h;
        }
        int result = 0;
        for(int i = 0; i < 3; i++) {
            if(y >= field[i][0]) {
                 int tmp = (int) (((h /100.0) * field[i][1]) + h);
                result = Math.max(result, solve(tmp, y - field[i][0]));
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        H = Double.parseDouble(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        field = new int[3][2];
        field[2][0] = 1;
        field[1][0] = 3;
        field[0][0] = 5;

        field[2][1] = 5;
        field[1][1] = 20;
        field[0][1] = 35;

        bw.write(solve(H,Y)+"");
        bw.flush();
        bw.close();
    }
}
