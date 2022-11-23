package programmers.level2;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class 카카오_캐시 {

    public int solution(int cacheSize, String[] cities) {
        //캐시할 HashMap
        //캐시에 있으면 실행시간 +1, bit++
        //캐시에 없으면 실행시간 +5
        //캐시에 없으면 가장 오랫동안 사용하지 않은 도시 찾아 삭제 후 새로운 도시 저장

        if(cacheSize == 0)
            return cities.length * 5;

        if(cities.length <= 0)
            return 0;

        Map<String, Integer> cached = new HashMap<>(cacheSize);
        int time = 0;

        for(int i = 0; i < cities.length; i++) {
            final String lowerCase = cities[i].toLowerCase();

            if(cached.get(lowerCase) == null){
                time += 5;

                saveCache(cached, cacheSize, lowerCase);
            }
            else {
                time += 1;

                getCached(cached, lowerCase);
            }
        }

        return time;
    }

    private void saveCache(Map<String, Integer> cached, int cacheSize, String city) {
        //가장 최근에 들어온 bit가 제일 작음
        //가장 큰 bit의 도시를 교체함
        //제일 큰 bit를 찾을 때 bit가 작으면 +1해줌

        if(!cached.isEmpty()) {
            String maxCity = "";
            int maxUsed = -1;

            for (Map.Entry<String, Integer> entry : cached.entrySet()) {
                if (entry.getValue() > maxUsed) {
                    maxCity = entry.getKey();
                    maxUsed = entry.getValue();
                }

                cached.put(entry.getKey(), entry.getValue() + 1);
            }

            if(cached.size() >= cacheSize) {
                cached.remove(maxCity);
            }
        }

        cached.put(city, 0);
    }

    private void getCached(Map<String, Integer> cached, String city) {
        if(!cached.isEmpty()) {
            for (Map.Entry<String, Integer> entry : cached.entrySet()) {
                cached.put(entry.getKey(), entry.getValue() + 1);
            }
        }

        cached.put(city, 0);
    }
}
