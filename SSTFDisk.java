import java.util.Scanner;

public class SSTFDisk {
    public static void main(String[] args) {
        // Scanner class to read user input
        Scanner sc = new Scanner(System.in);

        // Read the number of requests
        System.out.print("Enter the number of requests: ");
        int n = sc.nextInt();

        // Read the requests
        int[] disk = new int[n];
        System.out.println("Enter the requests: ");
        for (int i = 0; i < n; i++) {
            disk[i] = sc.nextInt();
        }

        // Read the initial position of head
        System.out.print("Enter the initial position of head: ");
        int rwhead = sc.nextInt();

        // Calculate and print the total head movement
        int seek_time = 0;
        while (n > 0) {
            int min = Integer.MAX_VALUE;
            int min_index = -1;
            for (int i = 0; i < n; i++) {
                if (Math.abs(rwhead - disk[i]) < min) {
                    min = Math.abs(rwhead - disk[i]);
                    min_index = i;
                }
            }
            System.out.println("Move the head from " + rwhead + " to " + disk[min_index]);
            seek_time += min;
            rwhead = disk[min_index];
            disk[min_index] = disk[n - 1];
            n--;
        }
        System.out.println("Total head movement: " + seek_time);
    }
}