package BOJ1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] applis;
    static int N;
    static int Num;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-- > 0) {
            Num = Integer.parseInt(br.readLine());
            Num++;
            applis = new int[Num];

            for(int i = 1; i < Num; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applis[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int max = applis[1];
            int result = 1;
            for(int i = 1; i < Num; i++) {
                if(max > applis[i]) {
                    max = applis[i];
                    result++;
                }
            }
            sb.append(result+"\n");
        }

        System.out.println(sb.toString());
    }

}
