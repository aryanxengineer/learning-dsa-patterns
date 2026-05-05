package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int low = 0, high = 0, maxFruitsCount = 0;

        while (high < fruits.length) {
            map.put(fruits[high], map.getOrDefault(fruits[high], 0) + 1);
            while(map.size() > 2){
                map.put(fruits[low], map.getOrDefault(fruits[low], 0) + 1);
                if(map.get(fruits[low]) == 0) map.remove(fruits[low]);
                low++;
            }
            maxFruitsCount = Math.max(maxFruitsCount, high++ - low + 1);
        }
        return maxFruitsCount;
    }

    public static void main(String[] args) {

    }
}
