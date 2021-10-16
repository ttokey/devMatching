package com.algorithm.devmatching;

import java.util.HashSet;
import java.util.Set;

public class First {
    public String solution(String[] registered_list, String new_id) {
        Set<String> inputSet = new HashSet<>();
        for (String list : registered_list) {
            inputSet.add(list);
        }

        String input = new_id;
        while (isInclude(inputSet, input)) {
            input = recommandString(input);
        }
        return input;
    }

    public boolean isInclude(Set<String> inputSet, String input) {
        if (inputSet.contains(input)) {
            inputSet.remove(input);
            return true;
        }
        return false;
    }

    public String recommandString(String input) {
        String SString = input.replaceAll("[\\d]", "");
        String NString = input.replaceAll("[^\\d]", "");

        if (!NString.isEmpty()) {
            int n = Integer.valueOf(NString);
            n++;
            return SString + String.valueOf(n);
        }
        return SString + "1";
    }
}
