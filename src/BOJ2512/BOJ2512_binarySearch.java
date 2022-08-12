package BOJ2512;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2512_binarySearch {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringTokenizer st2;
    static int N;
    static int totalSum;
    static int result = 0;

    public static void solve(int[] numArr, int start, int end) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        int midValue = 0;
        for (int i : numArr) {
            midValue += Math.min(i, mid);
        }
        if (midValue > totalSum) {
            solve(numArr, start, mid - 1);
        } else {
            result = Math.max(result, mid);
            solve(numArr, mid + 1, end);
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] numArr = new int[N];
        long maxSum = 0;
        int maxNum = 0;
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
            maxSum += numArr[i];
            maxNum = Math.max(maxNum, numArr[i]);
        }
//        Arrays.sort(numArr);
        totalSum = Integer.parseInt(br.readLine());

        solve(numArr, 0, maxNum);
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

}
