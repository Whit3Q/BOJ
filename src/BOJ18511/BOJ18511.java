package BOJ18511;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ18511 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int K;
    static Integer[] field;
    static int[] memory;
    public static int solve( int index, int count) {
        int tmp = 0;
        if(index == count) {
            for(int i = 0; i < count; i++) {
                tmp *= 10;
                tmp += memory[i];
            }
            if(N >= tmp) {
                return tmp;
            }
            return -1;
        }

        for(int i = 0 ; i < K; i++) {
            memory[index] = field[i];
            tmp = Math.max(tmp, solve(index+1,count));
        }

        return tmp;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int tmp = N;
        int count = 0;
        while(tmp != 0) {
            count++;
            tmp /= 10;
        }
        field = new Integer[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            field[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        Arrays.sort(field, Collections.reverseOrder());
        for(int i = 1; i < count+1; i++) {
            memory = new int[count];
            result = Math.max(result,solve(0,i));
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
