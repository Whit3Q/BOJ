package BOJ1786;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str2 = sc.nextLine();
        int strLength = str.length();
        int str2Length = str2.length();
        if (strLength < str2Length) System.out.println(0);
        else {
            final int power = 31;
            final int MOD = (int)1e9 + 7;
            long head = 1;
            long str2Hash = 0;
            long strHash = 0;

            for (int i = 0; i < str2Length; i++) {
                str2Hash = (str2Hash * power + str2.charAt(i)) % MOD;
                strHash = (strHash * power + str.charAt(i)) % MOD;
                if (i != 0) head = (head * power) % MOD;
            }
            LinkedList<Integer> ans = new LinkedList<>();
            for (int i = 0; i <= strLength - str2Length; i++) {
                if(strHash == str2Hash) ans.add(i + 1);
                if(i + str2Length == strLength) break;
                strHash = (power * (strHash - str.charAt(i) * head) + str.charAt(i + str2Length)) % MOD;
                if(strHash < 0) strHash += MOD;
            }
            System.out.println(ans.size());
            for(Integer e: ans) System.out.print(e + " ");
        }
    }
}