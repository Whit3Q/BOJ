package BOJ2635;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2635 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    public static ArrayList<Integer> solve() {
        int size = N / 2;
        int target = 0;
        ArrayList<Integer> result = null;
        for(int i = N/2; i <= N; i++ ) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int tmpNum = check(target, tmp, N, i, 2);
            if(tmp.size() != 0) {
                tmp.add(N);
                target = tmpNum;
                result = tmp;
            }
        }

        return result;
    }

    public static int check(int target, ArrayList<Integer> list, int num, int num2, int count) {
        if(num2 < 0) {
            return count-1;
        }
        int tmp = check(target, list, num2, num - num2, count + 1);
        if(tmp > target) {
            list.add(num2);
        }
        return tmp;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        ArrayList<Integer> result = solve();
        bw.write(result.size()+"\n");
        for(int i = result.size()-1; i >= 0; i--) {
            bw.write(result.get(i)+" ");
        }
        bw.flush();
        bw.close();
    }
}
