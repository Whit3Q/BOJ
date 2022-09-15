package BOJ13458;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringTokenizer st2;
    static int N;
    static int B;
    static int C;
    static int[] classN;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        classN = new int[N];
        st= new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st2.nextToken());
        C = Integer.parseInt(st2.nextToken());
        long result = 0;
        for(int i = 0; i < N; i++) {
            classN[i] = Integer.parseInt(st.nextToken()) - B;
            result++;
            if(classN[i] > 0) {
                result += classN[i]/C;
                if(classN[i]%C != 0) {
                    result++;
                }
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
