import java.util.*;

public class PriorityPremptive {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes:");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int ta[] = new int[n];
        int wt[] = new int[n];
        int f[] = new int[n];
        int k[] = new int[n];
        int p[] = new int[n];
        int i, st = 0, tot = 0;
        float avgwt = 0, avgta = 0;

        for (i = 0; i < n; i++) {
            pid[i] = i + 1;
            System.out.println("Enter process " + (i + 1) + " arrival time:");
            at[i] = sc.nextInt();
            System.out.println("Enter process " + (i + 1) + " burst time:");
            bt[i] = sc.nextInt();
            System.out.println("Enter process " + (i + 1) + " priority:");
            p[i] = sc.nextInt();
            k[i] = bt[i];
            f[i] = 0;
        }

        System.out.println("Gantt Chart:");
        System.out.print("|");
        int currentProcess = -1;
        for (int time = 0; ; time++) {
            int maxPriority = -1, c = n;
            if (tot == n)
                break;

            for (i = 0; i < n; i++) {
                if ((at[i] <= time) && (f[i] == 0) && (p[i] > maxPriority)) {
                    maxPriority = p[i];
                    c = i;
                }
            }

            if (c != n && c != currentProcess) {
                System.out.print("P" + pid[c] + "|");
                currentProcess = c;
            } else {
                System.out.print(" ");
            }

            if (c == n) {
                continue;
            } else {
                bt[c]--;
                if (bt[c] == 0) {
                    ct[c] = time + 1;
                    f[c] = 1;
                    tot++;
                    currentProcess = -1;
                }
            }
        }

        System.out.println("\n\nPID  Arrival  Burst  Priority  Complete  Turnaround  Waiting");
        for (i = 0; i < n; i++) {
            ta[i] = ct[i] - at[i];
            wt[i] = ta[i] - k[i];
            avgwt += wt[i];
            avgta += ta[i];
            System.out.println(pid[i] + "\t" + at[i] + "\t" + k[i] + "\t" + p[i] + "\t\t" + ct[i] + "\t\t" + ta[i] + "\t\t" + wt[i]);
        }

        System.out.println("\nAverage turnaround time is " + (float) (avgta / n));
        System.out.println("Average waiting time is " + (float) (avgwt / n));
        sc.close();
    }
}