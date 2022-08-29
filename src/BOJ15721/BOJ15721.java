package BOJ15721;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ15721 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static StringTokenizer st;
    static int N;
    static int T;
    static boolean M;
    static boolean[] field;
    static int maxCount = 10001;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        field = new boolean[N];
        T = Integer.parseInt(br.readLine());
        if(Integer.parseInt(br.readLine()) == 1) {
            M = true;
        }
        //false : 뻔 true : 데기
        int circle = 2;
        int count = 4;
        int count2 = circle;
        int count3 = circle;
        int zeroCount = 0;
        int oneCount = 0;
        boolean now = true;
        if(N == 0) {
            return;
        }
        int i = 0;
        while(zeroCount < maxCount || oneCount < maxCount) {
            int tmp = i % N;
            if(count != 0) {
                count--;
                now = !now;
                if(now) {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            } else if(count2 != 0) {
                count2--;
                zeroCount++;
            } else if(count3 != 0){
                count3--;
                oneCount++;
            }

            if(M && T == oneCount) {
                System.out.println(tmp);
                return;
            } else if(!M && T == zeroCount){
                System.out.println(tmp);
                return;
            }

            if(count == 0 && count2 ==0 && count3 ==0) {
                count =4;
                circle++;
                count2 = circle;
                count3 = circle;
                now = true;
            }
            i++;
        }

    }
}
