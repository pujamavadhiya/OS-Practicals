//import java.util.Scanner;
//
//public class RoundRobin {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter no of processes:");
//        int n = sc.nextInt();
//        int pid[] = new int[n];
//        int at[] = new int[n];
//        int bt[] = new int[n];
//        int ct[] = new int[n];
//        int tat[] = new int[n];
//        int wt[] = new int[n];
//        int rt[] = new int[n];
//        int timeQuantum, tot=0;
//        float avgwt=0, avgta=0;
//
//        for (int i=0; i<n; i++) {
//            pid[i] = i+1;
//            System.out.println("Enter process " +(i+1)+ " arrival time:");
//            at[i] = sc.nextInt();
//            System.out.println("Enter process " +(i+1)+ " burst time:");
//            bt[i] = sc.nextInt();
//            rt[i] = bt[i];
//        }
//
//        System.out.println("Enter time quantum:");
//        timeQuantum = sc.nextInt();
//
//        int currentTime = 0;
//        boolean done = false;
//        while (!done) {
//            done = true;
//            for (int i=0; i<n; i++) {
//                if (rt[i] > 0) {
//                    done = false;
//                    if (rt[i] > timeQuantum) {
//                        currentTime += timeQuantum;
//                        rt[i] -= timeQuantum;
//                    }
//                    else {
//                        currentTime += rt[i];
//                        ct[i] = currentTime;
//                        rt[i] = 0;
//                    }
//                }
//            }
//        }
//
//        for(int i=0; i<n; i++) {
//            tat[i] = ct[i] - at[i];
//            wt[i] = tat[i] - bt[i];
//            avgwt += wt[i];
//            avgta += tat[i];
//        }
//
//        System.out.println("Process\tAT\tBT\tCT\tTAT\tWT");
//        for(int i=0; i<n; i++) {
//            System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
//        }
//
//        System.out.println("\nAverage TAT is " + (float)(avgta/n));
//        System.out.println("Average WT is " + (float)(avgwt/n));
//        sc.close();
//    }
//}





import java.util.*;
public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of process: ");
        int num = sc.nextInt();
        int B[] = new int[num];
        for(int i=0; i<num; i++){
            System.out.println("Enter burst time for p"+(i+1));
            B[i]=sc.nextInt();
        }
        System.out.println("Enter quantum time: ");
        int q = sc.nextInt();
        int wait[]= new int[num];
        int total;

        do{
            for(int i=0; i<num; i++){
                if(B[i]>q){
                    for(int j=0; j<num; j++){
                        if(j!=i && B[j]!=0){
                            wait[j]+=q;
                        }
                    }
                    B[i]-=q;
                }
                else{
                    for(int j=0;j<num;j++){
                        if(j!=i && B[j]!=0){
                            wait[j]+=B[i];
                        }
                    }
                    B[i]=0;
                }
            }
            total=0;
            for(int i=0;i<num;i++){
                total+=B[i];
            }
        }
        while(total!=0);
        System.out.println("Process\t\t\twaiting time");
        float total_wait=0;
        for(int i=0; i<num; i++){
            System.out.println("p"+(i+1)+"\t\t\t"+wait[i]);
            total_wait+=wait[i];
        }
    }
}




















