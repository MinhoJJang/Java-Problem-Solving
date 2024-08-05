package BOJ_11571;

import java.io.*;
import java.util.*;

public class Main {

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

            ArrayList<Integer> qx = new ArrayList<>();
            ArrayList<Integer> rx = new ArrayList<>();

            int q = a / b;
            int r = a - (q * b);

            rx.add(r);
            sb.append(q+".");

            // r, b를 최대한 나눠야 한다. 2/14 나 1/7 이나 다를 게 없기 때문이다.
            double sr = Math.sqrt(r);

            for (int i = 2; i <= r; i++) {
                if(b % i == 0 && r % i == 0){
                    b /= i;
                    r /= i;
                }
            }

            RB rb = new RB(r, b);
            // 이전에 r과 b로 이루어진 적이 있었다면, 이미 순환소수를 구해놓은 상태이다.
            if(memo.containsKey(rb)){
                sb.append(memo.get(rb).substring(1));
                bw.write(sb.toString()+"\n");
                continue;
            }

            if(r == 0){
                // 이 경우는 한번에 나눠진 경우이다. 끝내버리자.
                sb.append("(0)");
                bw.write(sb.toString()+"\n");
                continue;
            }

            int idx = 0;
            
            // 나머지가 0이거나, 나머지가 반복되면 종료한다.
            while(true){

                a = r * 10;
                q = a / b;
                r = a - (q * b);
                
                qx.add(q);
                String s;

                if(r == 0) {
                    // 나누어 떨어졌다는 의미이므로 모든 몫을 합치고 마지막에 (0)을 추가하면 된다. 
                    for(Integer i : qx){
                        sb.append(i);
                    }
                    sb.append("(0)");
                    s = sb.toString();
                    bw.write(s+"\n");
                    memo.put(rb, s.substring(s.indexOf(".")+1));
                    break;
                }
                else if(rx.contains(r)){
                    // 만약 기존 나머지와 같은 값의 나머지가 존재한다면, 이제 순환소수의 시작점 및 끝점을 찾은 것이다. 

                    int start = rx.indexOf(r);

                    if(start == idx){
                        // 이 경우는 1자리 수 반복되는 순환소수이다. 
                        for (int i = 0; i < qx.size(); i++) {
                            if(i == start){
                                sb.append("("+qx.get(i)+")");
                            }
                            else {
                                sb.append(qx.get(i));
                            }
                        }
                        s = sb.toString();
                        bw.write(s+"\n");
                        memo.put(rb, s.substring(s.indexOf(".")));
                        break;
                    }
                    else{
                        // 이 경우는 n자리가 반복되는 순환소수이다.
                        int end = idx;
                        for (int i = 0; i < qx.size(); i++) {
                            if(i == start){
                                sb.append("(");
                            }

                            sb.append(qx.get(i));

                            if(i == end) {
                                sb.append(")");
                            }
                        }
                        s = sb.toString();
                        bw.write(s+"\n");
                        memo.put(rb, s.substring(s.indexOf(".")));
                        break;
                
                    }
                }
                
                rx.add(r);
                idx++;
            }

        }

        bw.flush();
    }
}
