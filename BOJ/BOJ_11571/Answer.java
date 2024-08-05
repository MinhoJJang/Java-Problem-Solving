//package BOJ_11571;

import java.io.*;
import java.util.*;

public class Answer {

    static class RB {
        int r;
        int b;

        RB(int r, int b){
            this.r = r;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RB rb = (RB) o;
            return r == rb.r && b == rb.b;
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(r, b);
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        Map<RB, String> memo = new HashMap<>();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int a = Integer.parseInt(st.nextToken()); // 분자
            int b = Integer.parseInt(st.nextToken()); // 분모

            int q = a / b;
            int r = a % b;

            sb.append(q).append(".");

            // r, b를 최대한 나눠야 한다. 2/14 나 1/7 이나 다를 게 없기 때문이다.
            int gcd = gcd(r, b);
            r /= gcd;
            b /= gcd;

            RB rb = new RB(r, b);
            // 이전에 r과 b로 이루어진 적이 있었다면, 이미 순환소수를 구해놓은 상태이다.
            if (memo.containsKey(rb)) {
                sb.append(memo.get(rb).substring(1));
                bw.write(sb.toString() + "\n");
                continue;
            }

            if (r == 0) {
                // 이 경우는 한번에 나눠진 경우이다. 끝내버리자.
                sb.append("(0)");
                bw.write(sb.toString() + "\n");
                continue;
            }

            Map<Integer, Integer> seenRemainders = new HashMap<>();
            List<Integer> quotient = new ArrayList<>();
            int idx = 0;
            boolean isRepeating = false;

            while (r != 0) {
                if (seenRemainders.containsKey(r)) {
                    isRepeating = true;
                    break;
                }

                seenRemainders.put(r, idx++);
                r *= 10;
                quotient.add(r / b);
                r %= b;
            }

            if (isRepeating) {
                int start = seenRemainders.get(r);
                for (int i = 0; i < quotient.size(); i++) {
                    if (i == start) {
                        sb.append("(");
                    }
                    sb.append(quotient.get(i));
                }
                sb.append(")");
            } else {
                for (int qDigit : quotient) {
                    sb.append(qDigit);
                }
                sb.append("(0)");
            }

            String result = sb.toString();
            bw.write(result + "\n");
            memo.put(rb, result.substring(result.indexOf(".")));
        }

        bw.flush();
    }
}