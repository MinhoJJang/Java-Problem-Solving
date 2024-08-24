//package BOJ_1331;

import java.util.*;
import java.io.*;

public class Main {

    static class Location {
        char x;
        char y;

        Location(char x, char y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean checkValid(Location a, Location b) {

        int diff_1 = Math.abs(a.x - b.x);
        int diff_2 = Math.abs(a.y - b.y);

        if (diff_1 == 0 || diff_2 == 0)
            return false;

        if (diff_1 + diff_2 != 3)
            return false;

        return true;
    }

    static boolean checkVisited(boolean[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (!map[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Location> queue = new LinkedList<>();
        boolean[][] map = new boolean[6][6];

        for (int i = 0; i < 36; i++) {
            String s = sc.nextLine();
            queue.add(new Location(s.charAt(0), s.charAt(1)));
        }

        queue.add(queue.peek());
        String answer = "Valid";
        Location lo = queue.poll();
        map[lo.x - 'A'][lo.y - '1'] = true;

        while (!queue.isEmpty()) {
            Location next = queue.poll();
            if (!checkValid(lo, next)) {
                answer = "Invalid";
                break;
            }
            map[next.x - 'A'][next.y - '1'] = true;
            lo = next;
        }

        if (!checkVisited(map)) {
            answer = "Invalid";
        }

        System.out.println(answer);
    }
}
