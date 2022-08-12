package BOJ1822;

import java.io.*;
import java.util.*;

// 음 이분탐색이라 ...왜 빠르지 내가 놓치고 있는게 있나?
public class BOJ1822_4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int A;
    static int B;
    static int[] aArr;
    static int[] bArr;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        aArr = new int[A];
        bArr = new int[B];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(aArr);
        Arrays.sort(bArr);

        List<Integer> list = new ArrayList<>();

        for (int target : aArr) {
            boolean result = binarySearch(target);

            if (!result) {
                list.add(target);
            }
        }

        sb.append(list.size()).append("\n");

        for (int idx : list) {
            sb.append(idx).append(" ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static boolean binarySearch(int target) {
        int start = 0;
        int end = bArr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (bArr[mid] > target) {
                end = mid - 1;
            } else if (bArr[mid] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
