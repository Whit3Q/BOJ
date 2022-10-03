package BOJ10039;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static char[][] field;
    static int N;

    public static void main(String[] args) throws IOException {
        int result = 0;
        for(int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num < 40)  {
                result += 40;
            } else {
                result += num;
            }
        }

        System.out.println(result/5);
    }
}
