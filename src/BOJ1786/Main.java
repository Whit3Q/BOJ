package BOJ1786;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String str;
    static String str2;
    static int strLength;
    static int str2Length;
    static long strHash;
    static long str2Hash;
    static final long power = 31;
    static long head = 1;
    static long result;
    static StringBuilder sb;

    static final int MOD = (int)1e9 + 7;

    public static long mod(long n) {
        if(n >= 0) return n%MOD;
//		return ((-n/MOD+1)*MOD + n) % MOD;
        return n%MOD + MOD;
    }

    public static void main(String[] args) throws IOException {
        str = br.readLine();
        str2 = br.readLine();
        strLength = str.length();
        str2Length = str2.length();
        if(strLength < str2Length) {
            System.out.println(0);
            return;
        }

        for(int i = 0; i < str2Length; i++) {
            strHash = (strHash * power + str.charAt(i)) % MOD;
            str2Hash = (str2Hash * power + str2.charAt(i)) % MOD;
            if (i != 0) head = (head * power) % MOD;
        }

        sb = new StringBuilder();

        for(int i = 0; i < strLength - str2Length + 1; i++) {

            if(strHash == str2Hash) { // 해시가 같다면
                result++;
                sb.append(i+1);
                sb.append(" ");
            }

            if(i + str2Length == strLength) {
                break;
            }

            strHash = (power * (strHash - str.charAt(i) * head) + str.charAt(i + str2Length)) % MOD;
            if(strHash < 0) strHash += MOD;
        }

        bw.write(result+"\n");
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
