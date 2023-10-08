package org.zhendong;

import java.util.HashMap;
import java.util.HashSet;

public class simple383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> record = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            record.put(c,record.getOrDefault(c,0)+1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!record.containsKey(c)){
                return false;
            }

            if (record.get(c) == 0){
                return false;
            }

            record.put(c, record.get(c)-1);
        }

        return true;
    }
}
