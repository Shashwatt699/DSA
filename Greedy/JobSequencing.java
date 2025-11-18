import java.util.*;

public class JobSequencing {
    static class Job {
        int deadline;
        int profit;
        int id; // 1-A, 2-B, 3-C ....

        Job(int i, int d, int p) { // Constructor
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        int jobInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        // Using arraylist to store objects of class Jobs
        ArrayList<Job> jobs = new ArrayList<>();

        // Storing each Object using info from JobInfo, one by one in jobs arraylist
        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);
        // Descending Order of Profit

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                time++;
                seq.add(curr.id);
            }
        }

        // Print Sequence
        System.out.println("Max jobs which gives max Profit and does not clash = " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();

    }
}
