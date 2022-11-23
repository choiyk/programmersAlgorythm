package programmers.level2;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class 카카오_캐시2 {

    public int solution(int cacheSize, String[] cities) {
        //캐시는 저장 순서를 지켜야 한다.
        //도시명으로 빠르게 검색할 수 있어야 한다.
        //-> LinkedHashSet
        //도시명은 lowercase로 저장한다.
        //캐시에 저장 공간이 있으면 맨 뒤에 저장
        //저장 공간이 없으면 가장 처음을 삭제하고 맨 뒤에 저장
        //캐시에 존재하면 해당 도시를 캐시에서 삭제하고 맨 뒤에 저장

        if(cacheSize == 0)
            return cities.length * 5;

        if(cities.length == 0)
            return 0;

        Set<String> cached = new LinkedHashSet<>(cacheSize);
        int time = 0;

        for(int i = 0; i < cities.length; i++) {
            final String city = cities[i].toLowerCase();

            if(getCityFromCached(cached, city) != null) {
                time += 1;
            }
            else {
                cache(cached, cacheSize, city);

                time += 5;
            }
        }

        return time;
    }

    private String getCityFromCached(Set<String> cached, String city) {
        if(cached.contains(city)) {
            cached.remove(city);
            cached.add(city);

            return city;
        }
        else {
            return null;
        }
    }

    private void cache(Set<String> cached, int cacheSize, String city) {
        if(cached.size() >= cacheSize) {
            Iterator<String> iterator = cached.iterator();

            String res = iterator.next();

            cached.remove(res);
        }

        cached.add(city);
    }
}
