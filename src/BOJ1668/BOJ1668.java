package BOJ1668;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1668 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] field;
    public static int[] solve(int[] field) {
        int countRight = 1;
        int countLeft = 1;
        int maxIndex = 0;
        int maxIndex2 = N-1;
        for(int i = 1; i < N; i++) {
            if(field[maxIndex] < field[i]) {
                countLeft++;
                maxIndex = i;
            }
        }

        for(int i = N - 2; i >= maxIndex; i--) {
            if(field[maxIndex2] < field[i] ) {
                countRight++;
                maxIndex2 = i;
            }
        }

        return new int[] {countLeft, countRight};
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        field = new int[N];

        for(int i = 0 ; i < N; i++ ) {
            field[i] = Integer.parseInt(br.readLine());
        }

        int[] result = solve(field);

        for(int num : result) {
            bw.write(num+"\n");
        }
        bw.flush();
        bw.close();
    }
}
