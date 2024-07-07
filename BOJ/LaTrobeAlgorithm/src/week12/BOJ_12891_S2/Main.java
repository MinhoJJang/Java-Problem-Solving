package week12.BOJ_12891_S2;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
    }

    static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

    static boolean passwordSafetyCheck(String password, int[] cond, char[] DNA) {
        for (int i = 0; i < 4; i++) {
            if (countChar(password, DNA[i]) >= cond[i]) continue;
            return false;
        }
        return true;
    }
}
