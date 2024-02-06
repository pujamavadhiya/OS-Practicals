import java.util.Scanner;

public class FCFSDisc
{
    public static void main(String args[])
    {
        int i, n, rwhead, dist, seek_time=0;
        int disk[] = new int[100];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of disk locations");
        n = scan.nextInt();

        System.out.println("Enter the disk locations");
        for(i=0;i<n;i++)
        {
            disk[i] = scan.nextInt();
        }

        System.out.println("Enter the initial head position");
        rwhead = scan.nextInt();

        System.out.println("Seek Sequence is");
        System.out.print(rwhead);

        for(i=0;i<n;i++)
        {
            dist = Math.abs(rwhead-disk[i]);
            seek_time+=dist;
            rwhead = disk[i];
            System.out.print(" --> "+disk[i]);
        }
        System.out.println("\nTotal Seek Time is "+seek_time);
    }
}