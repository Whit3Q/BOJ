package BOJ1629;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1692_2 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static long power(long num1, long num2, long num3) {
        if (num2 == 1) {
            return num1;
        }
        if (num2 == 0) {
            return 1;
        }
        long result = power(num1, num2 / 2, num3) % num3;

        if (num2 % 2 == 0) {
            return (result % num3 * result % num3) % num3;
        } else {
            return (result % num3 * result % num3 * num1 % num3) % num3;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long num1 = Long.parseLong(st.nextToken());
        long num2 = Long.parseLong(st.nextToken());

        long num3 = Long.parseLong(st.nextToken());

        System.out.println(power(num1 % num3, num2, num3));
    }

}
