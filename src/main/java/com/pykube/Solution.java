package com.pykube;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Solution {
    public static List<String> calculateMentionStatistics(String[] members, String[] messages) {
        Map<String, Integer> mentionCounts = new TreeMap<>();

        // Initialize mention counts for each member
        for (String member : members) {
            mentionCounts.put(member, 0);
        }
        // Count mentions in messages
        for (String message : messages) {
            for (String member : members) {
                // Check for mentions (case-sensitive)
                String mention = "@" + member;
                int count = countOccurrences(message, mention);
                mentionCounts.put(member, mentionCounts.get(member) + count);
            }
        }
        
        List<String> list=mentionCounts.entrySet().stream().map(e->e.getKey()+"="+e.getValue()).collect(Collectors.toList());
        return list;
    }

    // Helper method to count occurrences of a substring in a string
    private static int countOccurrences(String message, String mention) {
        int count = 0;
        int index = 0;
        while ((index = message.indexOf(mention, index)) != -1) {
            count++;
            index += mention.length();
        }

        return count;
    }

    public static void main(String[] args) {
        String[] members = {"id1", "id239", "id983","id123"};
        String[] messages = {
            "This is an example with no mentions",
            "This is an example with @id1 one mention of one user",
            "This is an example with @id123,@id983 one mention of two users",
            "This is an example with @id1,id123,id983 several mentions of several users @id239"
        };

        List<String> stats = calculateMentionStatistics(members, messages);
        System.out.println(stats);
    }
}
