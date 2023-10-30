package org.zhendong;

import java.util.*;

public class hard332 {
    Map<String, Map<String,Integer>> ticketMap = new HashMap<>();
    // <出发机场, map<到达机场, 航班次数>>
    Deque<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
//        Collections.sort(tickets,(a,b) -> a.get(1).compareTo(b.get(1)));
        for (List<String> ticket : tickets) {
            Map<String, Integer> temp;
            if (ticketMap.containsKey(ticket.get(0))) {
                temp = ticketMap.get(ticket.get(0));
                temp.put(ticket.get(1),temp.getOrDefault(ticket.get(1),0)+1);//终点和次数
            }else {
                temp = new TreeMap<>();//升序Map
                temp.put(ticket.get(1), 1);
            }
            ticketMap.put(ticket.get(0),temp);
        }
        res.add("JFK");
        backtracking(tickets.size());
        return new ArrayList<>(res);
    }

    private boolean backtracking(int ticketNum) {
        if (res.size() == ticketNum + 1) {
            return true;
        }

        String last = res.getLast();
        if (ticketMap.containsKey(last)) {
            for (Map.Entry<String, Integer> entry : ticketMap.get(last).entrySet()) {
                int count = entry.getValue();
                if (count > 0) {
                    res.add(entry.getKey());
                    entry.setValue(count-1);
                    if (backtracking(ticketNum)) return true;
                    entry.setValue(count);
                    res.removeLast();
                }
            }
        }
        return false;
    }


}
