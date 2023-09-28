package BOJ_10158_S4;

import java.util.Scanner;

public class Main {

    final static int TOP_RIGHT = 0;
    final static int BOT_RIGHT = 1;
    final static int BOT_LEFT = 2;
    final static int TOP_LEFT = 3;

    final static int x = 0;
    final static int y = 1;
    final static int same = 2;

    static boolean insideBox(int[] end, int[][] box){
        if(end[x] >= 0 && end[x] <= box[TOP_RIGHT][x] && end[y] >= 0 && end[y] <= box[TOP_RIGHT][y]){
            return true;
        }
        return false;
    }

    static int compare(int a, int b){
        if(Math.abs(a)<Math.abs(b)){
            return x;
        }
        else if(Math.abs(a)>Math.abs(b)){
            return y;
        }
        return same;
    }

    static int[] fn(int[] start, int[] end, int[][] box, int dir){

        if(insideBox(end, box)){
            // 최종 좌표가 box 내에 존재하므로 해당 좌표가 최종 위치임
            return end;
        }

        int closeOne;
        int distance;
        // 경계점은 TOP_RIGHT일 경우 오른쪽 위 꼭짓점 좌표이다.
        // 1. 경계점까지 x,y 중 뭐가 더 가까운지 찾는다. 0이면 x, 1이면 y, 2이면 동시에 경계점에 도착했다는 뜻
        closeOne = compare(start[x] - box[dir][x], start[y] - box[dir][y]);

        if(dir == TOP_RIGHT){
            if(closeOne == x){
                distance = Math.abs(start[x] - box[dir][x]);
                dir = TOP_LEFT;
                end[x] -= 2*(end[x] - (start[x] + distance));
            }
            else if(closeOne == y){
                distance = Math.abs(start[y] - box[dir][y]);
                dir = BOT_RIGHT;
                end[y] -= 2*(end[y] - (start[y] + distance));
            }
            else{
                distance = Math.abs(start[y] - box[dir][y]);
                dir = BOT_LEFT;
                end[y] -= 2*(end[y] - (start[y] + distance));
                end[x] -= 2*(end[x] - (start[x] + distance));
            }
            start[x] += distance;
            start[y] += distance;
        }
        else if(dir == BOT_RIGHT){
            if(closeOne == x){
                distance = Math.abs(start[x] - box[dir][x]);
                dir = TOP_RIGHT;
                end[x] -= 2*(end[x] - (start[x] + distance));
            }
            else if(closeOne == y){
                distance = Math.abs(start[y] - box[dir][y]);
                dir = BOT_LEFT;

                end[y] -= 2*(end[y] - (start[y] - distance));
            }
            else{
                distance = Math.abs(start[y] - box[dir][y]);
                dir = TOP_LEFT;
                end[y] -= 2*(end[y] - (start[y] - distance));
                end[x] -= 2*(end[x] - (start[x] + distance));
            }
            start[x] += distance;
            start[y] -= distance;
        }
        else if(dir == BOT_LEFT){
            if(closeOne == x){
                distance = Math.abs(start[x] - box[dir][x]);
                dir = BOT_RIGHT;
                end[x] -= 2*(end[x] - (start[x] - distance));
            }
            else if(closeOne == y){
                distance = Math.abs(start[y] - box[dir][y]);
                dir = TOP_LEFT;
                end[y] -= 2*(end[y] - (start[y] - distance));
            }
            else{
                distance = Math.abs(start[y] - box[dir][y]);
                dir = TOP_RIGHT;
                end[y] -= 2*(end[y] - (start[y] - distance));
                end[x] -= 2*(end[x] - (start[x] - distance));
            }
            start[x] -= distance;
            start[y] -= distance;
        }
        else if(dir == TOP_LEFT){
            if(closeOne == x){
                distance = Math.abs(start[x] - box[dir][x]);
                dir = TOP_RIGHT;
                end[x] -= 2*(end[x] - (start[x] - distance));
            }
            else if(closeOne == y){
                distance = Math.abs(start[y] - box[dir][y]);
                dir = BOT_LEFT;

                end[y] -= 2*(end[y] - (start[y] + distance));
            }
            else{
                distance = Math.abs(start[y] - box[dir][y]);
                dir = BOT_RIGHT;
                end[y] -= 2*(end[y] - (start[y] + distance));
                end[x] -= 2*(end[x] - (start[x] - distance));
            }
            start[x] -= distance;
            start[y] += distance;
        }


        return fn(start, end, box, dir);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w, h, p, q, t;
        w = sc.nextInt();
        h = sc.nextInt();
        p = sc.nextInt();
        q = sc.nextInt();
        t = sc.nextInt();

        int[][] box = {
                {w, h},
                {w, 0},
                {0, 0},
                {0, h}
        };

        int[] start = {p, q};
        int[] end = {p+t, q+t};
        int dir = TOP_RIGHT;
        int[] answer = new int[2];

        answer = fn(start, end, box, dir);
        System.out.printf("%d %d", answer[x], answer[y]);

    }
}

// 메모리초과
// 너무 복잡함!!