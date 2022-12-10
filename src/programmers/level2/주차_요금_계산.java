package programmers.level2;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class 주차_요금_계산 {

    public int[] solution(int[] fees, String[] records) {
        Map<String, String> parking = new HashMap<>();
        Map<String, Integer> time = new HashMap<>();
        Queue<String> cars = new PriorityQueue<>();

        for(String record : records) {
            String[] recordArr = record.split(" ");

            if(!cars.contains(recordArr[1]))
                cars.offer(recordArr[1]);

            if(recordArr[2].equals("IN")) {
                parking.put(recordArr[1], recordArr[0]);
            }
            else {
                int parkTime = computeParkTime(parking.get(recordArr[1]), recordArr[0]);
                time.put(recordArr[1], time.getOrDefault(recordArr[1], 0) + parkTime);

                parking.remove(recordArr[1]);
            }
        }

        for(Map.Entry<String, String> entry : parking.entrySet()) {
            int parkTime = computeParkTime(entry.getValue(), "23:59");
            time.put(entry.getKey(), time.getOrDefault(entry.getKey(), 0) + parkTime);
        }

        for(Map.Entry<String, Integer> entry : time.entrySet()) {
            int fee = fees[1];

            if(entry.getValue() > fees[0])
                fee += (entry.getValue() - fees[0]) % fees[2] > 0 ? ((entry.getValue() - fees[0]) / fees[2] + 1) * fees[3] : ((entry.getValue() - fees[0]) / fees[2]) * fees[3];

            time.put(entry.getKey(), fee);
        }

        int[] answer = new int[cars.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = time.get(cars.poll());
        }

        return answer;
    }

    public int[] solution2(int[] fees, String[] records) {
        Map<String, String> parking = new HashMap<>();
        Map<String, Integer> time = new TreeMap<>();

        for(String record : records) {
            String[] recordArr = record.split(" ");

            if(recordArr[2].equals("IN")) {
                parking.put(recordArr[1], recordArr[0]);
            }
            else {
                int parkTime = computeParkTime(parking.get(recordArr[1]), recordArr[0]);
                time.put(recordArr[1], time.getOrDefault(recordArr[1], 0) + parkTime);

                parking.remove(recordArr[1]);
            }
        }

        for(Map.Entry<String, String> entry : parking.entrySet()) {
            int parkTime = computeParkTime(entry.getValue(), "23:59");
            time.put(entry.getKey(), time.getOrDefault(entry.getKey(), 0) + parkTime);
        }

        int i = 0;
        int[] answer = new int[time.size()];
        for(int value : time.values()) {
            int fee = fees[1];

            if(value > fees[0])
                fee += (value - fees[0]) % fees[2] > 0 ? ((value - fees[0]) / fees[2] + 1) * fees[3] : ((value - fees[0]) / fees[2]) * fees[3];

            answer[i++] = fee;
        }

        return answer;
    }

    private int computeParkTime(String in, String out) {
        String[] temp = in.split(":");
        LocalTime inTime = LocalTime.of(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]));

        temp = out.split(":");
        LocalTime outTime = LocalTime.of(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]));

        return (int) inTime.until(outTime, ChronoUnit.MINUTES);
    }
}
