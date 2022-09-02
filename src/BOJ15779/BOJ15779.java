package BOJ15779;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ15779 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] field;

    public static int solve(int[] field, int index) {
        if(index == N) {
            return 0;
        }
        int result = 0;
        if(field[index - 1] > field[index -2]) { // 증가 1단계
            if(field[index] >= field[index-1]) {
                return 0;
            } else {
                result += solve(field, index+1) + 1;
            }
        } else if(field[index - 1] < field[index -2]){ //감소 1단계
            if(field[index] <= field[index-1]) {
                return 0;
            } else {
                result += solve(field, index+1) + 1;
            }
        } else { // 같을 때
            return 0;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        field = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            field[i] = Integer.parseInt(st.nextToken());
        }
        int result = 2;
        for(int i = 2; i < N; i++) {
            result = Math.max(result, solve(field, i)+2);
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
