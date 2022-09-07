package BOJ1251;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1251 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static String str;

    public static void main(String[] args) throws IOException {
        str = br.readLine();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i < str.length() - 1; i++) {//문자열 자르기
            String tmp1 = str.substring(0, i);
            String reverseTmp1 = strReverse(tmp1);
            for (int j = i + 1; j < str.length(); j++) {
                String tmp2 = str.substring(i, j);
                String tmp3 = str.substring(j, str.length());
                String reverseTmp2 = strReverse(tmp2);
                String reverseTmp3 = strReverse(tmp3);
                String sb = reverseTmp1 +
                        reverseTmp2 +
                        reverseTmp3;
                list.add(sb);

            }
        }
        Collections.sort(list);
        bw.write(list.get(0));
        bw.flush();
        bw.close();
    }

    public static String strReverse(String subStr) {
        StringBuilder sb = new StringBuilder();
        for (int i = subStr.length() - 1; i >= 0; i--) {
            sb.append(subStr.charAt(i));
        }

        return sb.toString();
    }
}
