package BOJ5568;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ5568 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int K;
    static int[] numbers;
    static boolean[] memory;
    static HashSet<Integer> hs;
    static int result;

    public static void solve() {

        for(int i = 0; i < N - 1; i++) {
            for(int j = i+1; j < N; j++) {
                String tmpS1 = String.valueOf(numbers[i]) + String.valueOf(numbers[j]);
                String tmpS2 = String.valueOf(numbers[j]) + String.valueOf(numbers[i]);
//                System.out.println(tmpS1);
//                System.out.println(tmpS2);
                int tmp = Integer.parseInt(tmpS1);
                int tmp2 = Integer.parseInt(tmpS2);
                if(!hs.contains(tmp)) {
                    hs.add(tmp);
                    result++;
                }

                if(!hs.contains(tmp2)) {
                    hs.add(tmp2);
                    result++;
                }
            }
        }
    }
    public static void check(ArrayList<Byte> list, boolean[] memory, int count, String str) {
        if(count == list.size()) {
            int tmp = Integer.parseInt(str);
            if(!hs.contains(tmp)) {
                hs.add(tmp);
                result++;
            }
            return;
        }

        for(int i = 0; i < list.size(); i++) {
            if(!memory[i]) {
                memory[i] = true;
                check(list, memory,count + 1, str+String.valueOf(numbers[list.get(i)]));
                memory[i] = false;
            }
        }
    }

    public static void solve(int index, int count, ArrayList<Byte> list) {
        if(count == K) {
            for(int i = 0 ; i < list.size(); i++) {
                memory[i] = true;
                check(list, memory, 1, String.valueOf(numbers[list.get(i)]));
                memory[i] = false;
            }
            return;
        }
        if(index > N -1 ){
            return;
        }

        list.add((byte) index);
        solve(index + 1, count+1, list);
        list.remove(list.size()-1);
        solve(index + 1, count, list);
    }

    public static void main(String[] args) throws IOException {
        hs = new HashSet<>();

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        numbers = new int[N];
        memory = new boolean[K];

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        solve(0,0,new ArrayList<>());
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
