package BOJ2744;

import java.io.*;

public class BOJ2744 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;

    public static void main(String[] args) throws IOException {
        str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if(tmp > 96 && tmp < 123) {
                tmp = (char) (tmp - 32);
            } else if (tmp > 64 && tmp < 91) {
                tmp = (char) (tmp + 32);
            }
            bw.write(String.valueOf(tmp));
        }

        bw.flush();
        bw.close();
    }

}
