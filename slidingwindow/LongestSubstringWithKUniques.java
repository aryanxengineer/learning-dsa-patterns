package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniques {
    public static int longestSubstringWithKUniques(String s, int k) {
        Map<Character, Integer> strMap = new HashMap<>();
        int high = 0, low = 0, maxLength = Integer.MIN_VALUE;

        while (high < s.length()) {

            strMap.put(s.charAt(high), strMap.getOrDefault(s.charAt(high), 0) + 1);

            while (strMap.size() > k && low < s.length()) {
                strMap.put(s.charAt(low), strMap.getOrDefault(s.charAt(low), 0) - 1);
                if (strMap.get(s.charAt(low)) == 0) {
                    strMap.remove(s.charAt(low));
                }
                low++;
            }

            if (strMap.size() == k)
                maxLength = Math.max(maxLength, high - low + 1);
            high++;
        }

        return maxLength == Integer.MIN_VALUE ? -1 : maxLength;
    }

    public static void main(String[] args) {

    }
}
