package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JobSequencingProblem {

    static class Job {
        char job_id;
        int deadline;
        int profit;

        Job(char job_id, int deadline, int profit) {
            this.deadline = deadline;
            this.job_id = job_id;
            this.profit = profit;
        }
    }

    // Greedy: sort by deadline asc; sweep from right to left,
    // use a max-heap by profit and fill available slots in each gap.
    public static void printJobScheduling(ArrayList<Job> arr) {
        int n = arr.size();

        // sort by deadline ascending
        Collections.sort(arr, Comparator.comparingInt(j -> j.deadline));

        ArrayList<Job> result = new ArrayList<>();

        // max-heap by profit
        PriorityQueue<Job> maxHeap =
            new PriorityQueue<>(Comparator.comparingInt((Job j) -> j.profit).reversed());

        for (int i = n - 1; i >= 0; i--) {
            int slotAvailable;
            if (i == 0) {
                slotAvailable = arr.get(i).deadline;
            } else {
                slotAvailable = arr.get(i).deadline - arr.get(i - 1).deadline;
            }

            // push current job
            maxHeap.add(arr.get(i));

            // fill available slots with highest-profit jobs seen so far
            while (slotAvailable > 0 && !maxHeap.isEmpty()) {
                Job job = maxHeap.poll(); // safer than remove()
                if (job == null) break;
                result.add(job);
                slotAvailable--;
            }
        }

        // optional: sort scheduled jobs by deadline to print
        Collections.sort(result, Comparator.comparingInt(j -> j.deadline));

        for (Job job : result) {
            System.out.print(job.job_id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Job> arr = new ArrayList<>();
        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));

        System.out.println("Following is maximum profit sequence of jobs");
        printJobScheduling(arr);
    }
}
