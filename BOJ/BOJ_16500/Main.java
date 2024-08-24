package BOJ_16500;

import java.util.*;

public class Main {

    static class State {
        int start;
        int end;
        String str;

        State(int start, int end, String str){
            this.start = start;
            this.end = end;
            this.str = str;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        int len = S.length();
        int N = Integer.parseInt(sc.nextLine());
        int answer = 0;

        ArrayList<String> words = new ArrayList<>();
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
 
        for (int i = 0; i < N; i++) {
            words.add(sc.nextLine());
        }

        queue.add(new State(0, 1, ""));
        visited.add("");

        while (!queue.isEmpty()) {
            State state = queue.poll();
            int start = state.start;
            int end = state.end;
            String str = state.str;

            if (str.equals(S)) {
                answer = 1;
                break;
            }

            while(end <= len){
                String find = S.substring(start, end);
                if (words.contains(find)) {
                    String newStr = str + find;
                    
                    if(!visited.contains(newStr)){
                        queue.add(new State(end, end + 1, newStr));
                        visited.add(newStr);
                    }
                }
                end++;
            }
        }

        System.out.println(answer);
    }
}
