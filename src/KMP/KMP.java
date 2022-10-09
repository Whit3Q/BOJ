package KMP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class KMP {
    static int result;

    public static int[] makeKMPTable(String str) {
        int strSize = str.length();
        int[] resultArr = new int[strSize];

        int index = 0;
        for(int i = 1; i < strSize; i++) {
            while(index > 0 && str.charAt(index) != str.charAt(i)) {
                index = resultArr[index - 1];
            }

            if(str.charAt(index) == str.charAt(i)) {
                resultArr[i] = ++index;
            }

        }


        return resultArr;
    }

    public static StringBuilder KMP(String str, String subStr) {
        boolean check = false;
        StringBuilder sb = new StringBuilder();
        int strSize = str.length();
        int subSize = subStr.length();

        int[] kmpTable =makeKMPTable(subStr);

        int index = 0;
        roof :
        for(int i = 0 ; i < strSize-subSize+1;) {

            for(;index < subSize; index++) {
                if(str.charAt(i + index) != subStr.charAt(index)) {
                    if(index == 0) {
                        i++;
                        break;
                    }
                    i += index - kmpTable[index - 1];
                    index = kmpTable[index - 1];
                    break;
                }
                if(index == subSize - 1) {
                    result++;
                    sb.append(i+1);
                    sb.append(" ");
                    if(index == 0) {
                        i++;
                    } else {
                        i += index - kmpTable[index - 1];
                        index = kmpTable[index - 1];
                    }
                    break;
//					check = true;
//					break roof;
                }
            }


        }

        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String str2 = br.readLine();
        StringBuilder sb = KMP(str, str2);
        if(result == 0) {
            System.out.println(0);
        } else {
            System.out.println(result);
            System.out.println(sb.toString());
        }
    }
}
