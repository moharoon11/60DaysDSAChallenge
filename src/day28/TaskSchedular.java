package day28;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class TaskSchedular {


    public static int leastInterval(char[] tasks, int n) {
        // Step 1: Calculate the frequency of each task
        Map<Character, Integer> taskFrequencyMap = new HashMap<>();
        for (char task : tasks) {
            taskFrequencyMap.put(task, taskFrequencyMap.getOrDefault(task, 0) + 1);
        }

        // Step 2: Create a max heap based on the frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(taskFrequencyMap.values());

        // Step 3: Initialize time and a queue to manage the cooldown
        int time = 0;
        Queue<int[]> cooldownQueue = new LinkedList<>();

        // Step 4: Start processing the tasks
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int currentTaskFrequency = maxHeap.poll() - 1;
                if (currentTaskFrequency > 0) {
                    cooldownQueue.add(new int[]{currentTaskFrequency, time + n});
                }
            }

            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time) {
                maxHeap.add(cooldownQueue.poll()[0]);
            }
        }

        return time;
    }
    public static void main(String[] args) {

    }
}
