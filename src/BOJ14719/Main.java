package BOJ14719;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int Y;
    static int X;
    static int[][] field;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        field = new int[Y][X];
        for(int i = 0; i < Y; i++) {
            Arrays.fill(field[i], 2);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < X; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            for(int j = 0; j < tmp; j++) {
                field[j][i] = 1;
            }
        }

        for(int i = 0; i < Y; i++) {
            if(field[i][0] == 2) {
                int count = 0;
                while(count < X-1 && field[i][count] != 1) {
                    field[i][count] = 0;
                    count++;
                }
            }

            if(field[i][X-1] == 2) {
                int count = X-1;
                while(count >= 0 && field[i][count] != 1) {
                    field[i][count] = 0;
                    count--;
                }
            }
        }

        int result = 0;
        for(int y = 0; y < Y; y++) {
            for(int x = 0; x < X; x++) {
                if(field[y][x] == 2) {
                    result++;
                }
            }
        }

        System.out.println(result);


//        for(int y = 0; y < Y; y++) {
//            for(int x = 0; x < X; x++) {
//                bw.write(field[y][x] + " ");
//            }
//            bw.newLine();
//        }

        bw.flush();
        bw.close();
    }
}
