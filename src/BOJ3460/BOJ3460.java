package BOJ3460;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ3460 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int target = Integer.parseInt(br.readLine());
            ArrayList<Boolean> result = new ArrayList<>();
            while (target > 0) {
                if (target % 2 == 1) {
                    result.add(true);
                } else {
                    result.add(false);
                }
                target /= 2;
            }

            for (int i = 0; i < result.size(); i++) {
                if (result.get(i)) {
                    bw.write(i + " ");
                }
            }

            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
