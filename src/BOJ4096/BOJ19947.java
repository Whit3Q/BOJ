package BOJ4096;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ19947 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;

    public static boolean check(int[] n) {
        int right = n.length-1;
        int left = 0;
        while(true) {
            if(right <= left) {
                return true;
            } else {
                if(n[right] != n[left]) {
                    return false;
                }
            }
            left++;
            right--;
        }
    }

    public static int solve(int[] n) {
        int result = 0;
        while (true) {
            if(check(n)) {
                break;
            }
            addOne(n);
            result++;
        }

        return result;
    }

    public static void addOne(int[] arr) {
        int index = arr.length - 1;
        while(true) {
            if(arr[index] + 1 == 10) {
                arr[index] = 0;
                index--;
                continue;
            } else {
                arr[index] += 1;
            }
            break;
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            String num = br.readLine();
            if (num.equals("0")) {
                break;
            }

            int[] nums = new int[num.length()];
            for(int i = 0; i < nums.length; i++) {
                nums[i] = num.charAt(i) - 48;
            }

            bw.write(solve(nums) + "");
            bw.newLine();

        }

        bw.flush();
        bw.close();
    }
}
