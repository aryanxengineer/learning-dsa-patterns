package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithoutRepeatingChar {
    public static int longestSubStrWithoutRepeatingChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int low = 0, high = 0, longString = 0;

        while (high < s.length()) {
            map.put(s.charAt(high), map.getOrDefault(s.charAt(high), 0) + 1);

            while (map.size() < high - low + 1) {
                map.put(s.charAt(low), map.getOrDefault(s.charAt(low), 0) - 1);
                if (map.get(s.charAt(low)) == 0)
                    map.remove(s.charAt(low));
                low++;
            }

            longString = Math.max(high++ - low + 1, longString);
        }
        return longString;
    }

    public static void main(String[] args) {

    }
}
