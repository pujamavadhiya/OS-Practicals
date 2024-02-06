import java.util.Scanner;
public class FCFS {
    public static void main(String[] args) {
        System.out.println("Enter no. of process : ");
        Scanner sc = new Scanner(System.in);
        int np = sc.nextInt();

        int pid[] = new int[np];
        int bt[] = new int[np];
        int at[] = new int[np];
        int tat[] = new int[np];
        int ct[] = new int[np];
        int wt[] = new int[np];
        int temp;
        float avgwt=0, avgtat=0;

        for (int i = 0; i < np; i++) {
            System.out.println("Enter Process : " + (i + 1) + " arrival time : ");
            at[i] = sc.nextInt();
            System.out.println("Enter Process : " + (i + 1) + " Burst Time : ");
            bt[i] = sc.nextInt();
            pid[i] = i + 1;
        }

        for (int i = 0; i < np; i++) {
            for (int j = 0; j < np-(i+1); j++) {
                if (at[j] > at[j+1]) {

                    temp = at[j];
                    at[j] = at[j+1];
                    at[j+1] = temp;

                    temp = pid[j];
                    pid[j] = pid[j+1];
                    pid[j+1] = temp;

                    temp = bt[j];
                    bt[j] = bt[j+1];
                    bt[j+1] = temp;
                }
            }
        }

        for (int i=0; i<np; i++){
            if(i == 0){
                ct[i] = at[i] + bt[i];
            }
            else {
                if( at[i] > ct[i-1]){
                    ct[i] = at[i] + bt[i];
                }
                else
                    ct[i] = ct[i-1] + bt[i];
                }
                tat[i] = ct[i] - at[i];
                wt[i] = tat[i] - bt[i];
                avgwt += wt[i];
                avgtat += tat[i];
            }

        System.out.println("Process\t\tAT\t\tBT\t\tCT\t\tTAT\t\tWT");

        for (int i = 0; i < np; i++) {
            System.out.println(pid[i] + "\t\t\t" + at[i] + "\t\t" + bt[i] + "\t\t" + ct[i] + "\t\t" + tat[i] + "\t\t" + wt[i]);

        }
        double avgWT = (double) avgwt / np;
        double avgTAT = (double) avgtat / np;
        System.out.println("Average Waiting Time: " + avgWT);
        System.out.println("Average Turnaround Time: " + avgTAT);
        System.out.println("gantt chart : ");

        for (int i = 0; i < np; i++) {
            System.out.println("P" + pid[i] + " ");
        }
    }
}
