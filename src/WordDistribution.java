import java.util.HashMap;
import java.util.Map;

public class WordDistribution {

    private final Map<String, Map<String, Integer>> distribution = new HashMap<>();

    public void addWord(String current, String next) {
        if (!distribution.containsKey(current)) {
            Map<String, Integer> countMap = new HashMap<>();
            countMap.put(next, 1);
            distribution.put(current, countMap);
            return;
        }

        Map<String, Integer> countMap = distribution.get(current);
        if (!countMap.containsKey(next)){
            countMap.put(next, 1);
        } else {
            Integer count = countMap.get(next);
            count += 1;
            countMap.put(next, count);
        }
        return;

    }

    public void distDisplay(){
        for (String current : distribution.keySet()){
            System.out.printf("%s%n", current);
            Map<String, Integer> countMap = distribution.get(current);
            for (String next: countMap.keySet()){
                System.out.printf("\t%s: %d%n", next, countMap.get(next));
            }
        }
    }
}