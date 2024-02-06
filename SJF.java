
import java.util.Scanner;

public class SJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of process : ");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        int f[] = new int[n];
        int st = 0, tot = 0;
        float avgwt = 0, avgtat = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i + 1) + " arrival time: ");
            at[i] = sc.nextInt();
            System.out.println("Enter process " + (i + 1) + " Burst time: ");
            bt[i] = sc.nextInt();
            pid[i] = i + 1;
            f[i] = 0;
        }

        boolean a = true;
        System.out.println("\nGantt Chart:");
        System.out.print("| ");
        while (true) {
            int c = n, min = 999;
            if (tot == n)
                break;

            for (int i = 0; i < n; i++) {
                if ((at[i] <= st) && (f[i] == 0) && (bt[i] < min)) {
                    min = bt[i];
                    c = i;
                }
            }
            if (c == n)
                st++;
            else {
                ct[c] = st + bt[c];
                st += bt[c];
                tat[c] = ct[c] - at[c];
                wt[c] = tat[c] - bt[c];
                f[c] = 1;
                tot++;
                avgwt += wt[c];
                avgtat += tat[c];
                System.out.print("P" + pid[c] + " | ");
            }
        }
        System.out.println("\n");

        System.out.println("Process\t\tAT\t\tBT\t\tCT\t\tTAT\t\tWT");

        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t\t\t" + at[i] + "\t\t" + bt[i] + "\t\t" + ct[i] + "\t\t" + tat[i] + "\t\t" + wt[i]);

        }
        double avgWT = (double) avgwt / n;
        double avgTAT = (double) avgtat / n;
        System.out.println("Average Waiting Time: " + avgWT);
        System.out.println("Average Turnaround Time: " + avgTAT);

    }
}
