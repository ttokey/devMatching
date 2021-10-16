package com.algorithm.devmatching;

import java.util.*;

public class Second {
    public int solution(int leave, String day, int[] holidays) {
        boolean[] holidayMap = new boolean[30];
        Set<Integer> holidaySet = getHoliday(day, holidays);
        for (Integer holiday : holidaySet) {
            holidayMap[holiday] = true;
        }
        int answer = 0;
        for (int i = 0; i < 30; i++) {
            answer = Math.max(answer, holidayCount(holidayMap, i, leave));
        }
        return answer;
    }

    public Integer holidayCount(boolean[] holidayMap, int start, int leave) {
        int count = 0;
        int leaveCount = 0;
        for (int i = start; i < 30; i++) {
            if (leaveCount == leave && !holidayMap[i]) {
                break;
            }
            if (!holidayMap[i]) {
                leaveCount++;
            }
            count++;

        }
        return count;
    }

    public Set<Integer> getHoliday(String day, int[] holidays) {
        Set<Integer> holidaySet = new HashSet<>();
        for (int holiday : holidays) {
            holidaySet.add(holiday - 1);
        }
        Map<String, List<Integer>> weekendStartMap = new HashMap<>();
        weekendStartMap.put("MON", Arrays.asList(5, 6));
        weekendStartMap.put("TUE", Arrays.asList(4, 5));
        weekendStartMap.put("WED", Arrays.asList(3, 4));
        weekendStartMap.put("THU", Arrays.asList(2, 3));
        weekendStartMap.put("FRI", Arrays.asList(1, 2));
        weekendStartMap.put("SAT", Arrays.asList(0, 1));
        weekendStartMap.put("SUN", Arrays.asList(6, 0));

        List<Integer> weekendStartList = weekendStartMap.get(day);
        for (Integer start : weekendStartList) {
            holidaySet.addAll(getWeekEnd(start));
        }
        return holidaySet;
    }

    public Set<Integer> getWeekEnd(int start) {
        Set<Integer> result = new HashSet<>();
        while (start < 30) {
            result.add(start);
            start += 7;
        }
        return result;
    }

}
