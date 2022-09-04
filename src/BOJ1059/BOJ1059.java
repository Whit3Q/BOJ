package BOJ1059;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1059 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int L;
    static int N;
    static int[] field;


    public static int solve(int[] field) {

        int index = -1;
        for (int i = 0; i < L + 1; i++) {
            if (field[i] == N) {
                index = i;
                break;
            }
        }



        if (index == -1) {
            System.out.println("warring");
        }

        ArrayList<Integer> list = new ArrayList<>();
        int target = 0;
        if(index == 0) {
            if (field[index + 1] == field[index]) {
                return 0;
            }
            for (int i = 1; i < field[index + 1]; i++) {
                if (i == N) {
                    target = list.size();
                }
                list.add(i);
            }
        } else if(index == L) {
            for (int i = field[index-1] + 1; i <= field[index]; i++) {
                if (i == N) {
                    target = list.size();
                }
                list.add(i);
            }
        } else {
            if (field[index + 1] == field[index]) {
                return 0;
            }
            for (int i = field[index - 1] + 1; i < field[index + 1]; i++) {
                if (i == N) {
                    target = list.size();
                }
                list.add(i);
            }
        }



        int result = 0;
        for (int i = 0; i <= target; i++) {
            for (int j = target; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        L = Integer.parseInt(br.readLine());
        field = new int[L + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            field[i] = Integer.parseInt(st.nextToken());
        }
        N = Integer.parseInt(br.readLine());
        field[L] = N;

        Arrays.sort(field);

        bw.write(solve(field) + "");
        bw.flush();
        bw.close();
    }
}
