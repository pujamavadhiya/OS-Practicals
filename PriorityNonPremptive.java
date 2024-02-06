import java.util.Scanner;

public class PriorityNonPremptive
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Number of processes
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();

        int pid[] = new int[n]; // Process ID's
        int at[] = new int[n]; // Arrival Time
        int bt[] = new int[n]; // Burst Time
        int prio[] = new int[n]; // Priority
        int ct[] = new int[n]; // Completion Time
        int ta[] = new int[n]; // Turn Around Time
        int wt[] = new int[n]; // Waiting Time
        float avgwt=0, avgta=0;

        // Accepting the inputs
        for (int i = 0; i < n; i++)
        {
            System.out.println("Enter details of process " + (i + 1));
            System.out.print("Enter Process ID: ");
            pid[i] = sc.nextInt();
            System.out.print("Enter Arrival Time: ");
            at[i] = sc.nextInt();
            System.out.print("Enter Burst Time: ");
            bt[i] = sc.nextInt();
            System.out.print("Enter Priority: ");
            prio[i] = sc.nextInt();
        }

        // Sorting the processes by their priority
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n - (i + 1); j++)
            {
                if (prio[j] > prio[j + 1])
                {
                    int temp;
                    temp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = temp;
                    temp = at[j];
                    at[j] = at[j + 1];
                    at[j + 1] = temp;
                    temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;
                    temp = prio[j];
                    prio[j] = prio[j + 1];
                    prio[j + 1] = temp;
                }
            }
        }

        // Displaying the table
        System.out.println("\nProcess\tAT\tBT\tPrio\tCT\tTAT\tWT");
        for (int i = 0; i < n; i++)
        {
            if (i == 0)
            {
                ct[i] = at[i] + bt[i];
            }
            else
            {
                if (at[i] > ct[i - 1])
                {
                    ct[i] = at[i] + bt[i];
                }
                else
                {
                    ct[i] = ct[i - 1] + bt[i];
                }
            }
            ta[i] = ct[i] - at[i];
            wt[i] = ta[i] - bt[i];
            avgwt+= wt[i];
            avgta+= ta[i];
            System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" +
                    prio[i] + "\t" + ct[i] + "\t" + ta[i] + "\t" + wt[i]);
        }
        System.out.println("\naverage tat is "+ (float)(avgta/n));
        System.out.println("average wt is "+ (float)(avgwt/n));
        sc.close();
    }
}