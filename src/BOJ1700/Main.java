package BOJ1700;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] flug;
    static int[] list;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        flug = new int[N];
        list = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) { //입력 받기
            list[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        roof :
        for(int i = 0; i < M; i++) { // 플러그 빈칸 채우기
            if(index > N-1) {
                index = i;
                break;
            }
            for(int j = 0; j < N; j++) {
                if(flug[j] == list[i]) {
                    continue roof;
                }
            }

            flug[index] = list[i];
            index++;
        }

        int result = isMultitap(flug, new boolean[N], index, 0);

        System.out.println(result);
    }

    public static int isMultitap(int[] flug, boolean[] memory, int index, int result) {
        if(index > M -1) { //리스트에서 넘어가면 종료
            return result;
        }

        for(int i = 0; i < N; i++) { //현재 꼽을 플러그가 꼽혀있으면 다음 리스트로
            if(flug[i] == list[index]) {
                return isMultitap(flug, memory, index+1, result);
            }
        }

        int lastUseIndex = -1;

        int size = 0;
        for(int i = 0; i < N; i++) {// 가장 오랜 기간 뒤에 사용되는 플러그
            int tmp = 0;
            for(int j = index; j < M; j++) {
                if(flug[i] == list[j]) {
                    memory[i] = true;
                    if(tmp > size) {
                        lastUseIndex = i;
                        size = tmp;
                    }
                    break;
                }
                tmp++;
            }
        }


        int notUseIndex = -1;
        for(int i = 0; i < N; i++) { // 사용되지 않는 플러그
            if(flug[i] == 0) { // 꼽히지 않은 플러그
                notUseIndex = i;
                break;
            }
            if(!memory[i]) { // 사용되지 않은 플러그
                notUseIndex = i;
                break;
            }
        }

        if(notUseIndex != -1) {
            flug[notUseIndex] = list[index];
            return isMultitap(flug, new boolean[N], index+1, result +1);
        } else {
            flug[lastUseIndex] = list[index];
            return isMultitap(flug, new boolean[N], index+1, result+1);
        }
    }
}
