//package BOJ_4848;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static double[] comma = new double[16];
    static String[] memo = new String[16];

    static String convert(int n){
        if(memo[n] != null) return memo[n];
        if(n == 0){
            memo[n] = "{}";
        }
        else if(n == 1){
            memo[n] = "{{}}";
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (int i = 0; i < n; i++) {
                if(memo[i] == null) memo[i] = convert(i);
                sb.append(memo[i]);
                if(i != n - 1) sb.append(",");
            }
            sb.append("}");
            memo[n] = sb.toString();
        }

        return memo[n];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 2; i < comma.length; i++) {
            comma[i] = Math.pow(2, i - 1) - 1;
        }

        while (T-- > 0) {
            String A = br.readLine();
            String B = br.readLine();
            int len_A = A.split(",").length - 1;
            int len_B = B.split(",").length - 1;
            int a = 0;
            int b = 0;
            for (int i = 0; i < comma.length; i++) {
                if(len_A == comma[i]) a = i;
                if(len_B == comma[i]) b = i;
            }

            // comma 개수가 0인 경우는 두 가지이다. 즉, len_A = 1인 친구가 for문을 나오면 무조건 a == 1인 상태이다. 만약 길이가 2라면 그 친구의 값은 0이다. 
            if(A.length() == 2) a = 0;
            if(B.length() == 2) b = 0;

            int target = a + b;
            
            bw.write(convert(target) + "\n");
        }

        bw.flush();
    }
}
