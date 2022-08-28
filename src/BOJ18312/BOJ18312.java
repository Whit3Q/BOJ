package BOJ18312;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ18312 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int K;
    static int hour = 0;
    static int minuit = 0;
    static int second = 0;

    //1번 3중 for문
    public static int solve1() {
        boolean checkH = false;
        boolean checkM = false;
        boolean checkS = false;
        int count = 0;
        for(int h = 0; h < N + 1; h++) {
            checkH = false;
            if(h < 10) {
                if(0 == K || h == K) {
                    checkH = true;
                }
            } else {
                int tmpH = h;
                while(tmpH != 0) {
                    if(tmpH % 10 == K) {
                        checkH = true;
                        break;
                    }
                    tmpH /= 10;
                }
            }
            for (int m = 0; m < 60; m++) {
                checkM = false;
                if(m < 10) {
                    if(0 == K || m == K) {
                        checkM = true;
                    }
                } else {
                    int tmpM = m;
                    while(tmpM != 0) {
                        if(tmpM % 10 == K) {
                            checkM = true;
                            break;
                        }
                        tmpM /= 10;
                    }
                }
                for (int s = 0; s < 60; s++) {
                    checkS = false;
                    if(s < 10) {
                        if(s == K || 0 == K) {
                            checkS = true;
                        }
                    } else {
                        int tmpS = s;
                        while(tmpS != 0) {
                            if(tmpS % 10 == K) {
                                checkS = true;
                                break;
                            }
                            tmpS /= 10;
                        }
                    }
                    if(checkH || checkM || checkS) {
//                        System.out.println(h+":"+m+":"+s);
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(solve1()));

        bw.flush();
        bw.close();

    }
}
