package BOJ2512;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2512 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringTokenizer st2;
    static int N;
    static int totalSum;

    public static int solve(int[] numArr, int index, int result, int totalSum) {
        if(index >= N) {
            return result;
        }
        if(numArr[index] == 0) {
            return solve(numArr, index+1, result, totalSum);
        }
        int tmpNum = (N-index) * (numArr[index] - result);
        if(totalSum > tmpNum) {
            return solve(numArr, index+1, result + (numArr[index]-result), totalSum - tmpNum);
        } else {
            return result + (totalSum/(N-index));
        }

    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] numArr = new int[N];
        for(int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArr);
        totalSum = Integer.parseInt(br.readLine());

        bw.write(solve(numArr, 0, 0,totalSum)+"");
        bw.flush();
        bw.close();
    }

}
