package org.zhendong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class middle406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];   // a - b 是升序排列，故在a[0] == b[0]的狀況下，會根據k值升序排列
            return b[0] - a[0];   //b - a 是降序排列，在a[0] != b[0]，的狀況會根據h值降序排列
        });
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] person : people) {
            que.add(person[1],person);
        }

        return que.toArray(new int[people.length][2]);

    }
}
