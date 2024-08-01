import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(String s) throws IOException {
        int answer = 0;
        int s_length = s.length();

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = s_length / 2; i > 0; i--) {

            String recentString = s.substring(0, i);
            int loc = i;
            int cnt = 1;
            int zip = 0;
            int converted = 0;

            while (loc <= s_length) {

                String currentString = "";
                if (loc + i > s_length) {
                    currentString = s.substring(loc, s_length);
                } else {
                    currentString = s.substring(loc, i + loc);
                }

                if (recentString.equals(currentString)) {
                    cnt++;
                } else {
                    if (cnt != 1) {
                        converted += Integer.toString(cnt).length() + recentString.length();
                    } else {
                        converted += recentString.length();
                    }

                    zip += cnt * i;

                    recentString = currentString;
                    cnt = 1;
                }

                loc += i;
            }

            converted += s_length - zip;

            numbers.add(converted);
        }

        answer = Collections.min(numbers);

        return answer;
    }
}