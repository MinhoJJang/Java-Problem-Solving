//package BOJ_1360;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    static final int NO = -1;
    static final int YES = 1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 명령, (숫자 혹은 문자), 실행 시간
        Stack<Map<String, Map<Object, Integer>>> input = new Stack<>();

        // 실행시간, 실행가능성
        Map<Integer, Integer> executable = new HashMap<>();
        Stack<Character> answer = new Stack<>();

        while (N-- > 0) {
            
            String[] order = br.readLine().split(" ");

            Integer execute_time = Integer.parseInt(order[2]); 
            Object o;
            if(order[0].equals("type")){
                o = order[1].charAt(0);
            }
            else {
                o = Integer.parseInt(order[1]);
            }

            Map<Object, Integer> in = Map.of(o, execute_time);

            input.add(Map.of(order[0], in));
            executable.put(execute_time, YES);     
        }

        while (!input.isEmpty()) {
            Map<String, Map<Object, Integer>> cur = input.pop();
            String command = cur.keySet().iterator().next();
            Map<Object, Integer> in = cur.get(command);
            Object o = in.keySet().iterator().next();
            Integer et = in.get(o);

            if(executable.get(et) == NO) continue;

            if(command.equals("type")){
                answer.add(o.toString().charAt(0));
            }
            else {
                // et - o ~ et - 1 까지 excutable에 - 붙이기
                Integer lo = Math.max(et - Integer.parseInt(o.toString()), 1);
                for (int i = lo; i < et; i++) {
                    if(!executable.containsKey(i)) continue;
                    executable.put(i, -executable.get(i));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!answer.isEmpty()) {
            sb.append(answer.pop());
        }

        System.out.println(sb);
        
    }
}
