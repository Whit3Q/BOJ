package BOJ1969;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1969 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] field;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new int[M][6]; //0-A, 1-C, 2-G, 3-T

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                switch (line.charAt(j)) {
                    case 'A' :
                        field[j][0]++;
                        break;
                    case 'C' :
                        field[j][1]++;
                        break;
                    case 'G' :
                        field[j][2]++;
                        break;
                    case 'T':
                        field[j][3]++;
                        break;
                }
            }
        }
        int result = 0;
        StringBuilder sb = new StringBuilder();
        for(int[] arr : field) {
            int tmp = 0;
            for(int i = 1; i < 4; i++) {
                if(arr[tmp] < arr[i]) {
                    tmp = i;
                }
            }
            switch (tmp) {
                case 0 :
                    sb.append("A");
                    break;
                case 1:
                    sb.append("C");
                    break;
                case 2:
                    sb.append("G");
                    break;
                case 3:
                    sb.append("T");
                    break;
            }
            result += N - arr[tmp];
        }
        sb.append("\n");
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
