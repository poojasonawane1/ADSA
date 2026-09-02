import java.util.Arrays;
import java.util.Scanner;

public class OptimalStorageOnTape {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of files
        System.out.print("Enter number of files: ");
        int n = sc.nextInt();

        int[] length = new int[n];

        // Read file lengths
        System.out.println("Enter length of each file:");
        for (int i = 0; i < n; i++) {
            length[i] = sc.nextInt();
        }

        // Sort files in ascending order
        Arrays.sort(length);

        int total = 0;
        int retrieval = 0;

        // Calculate total retrieval time
        for (int i = 0; i < n; i++) {
            retrieval = retrieval + length[i];
            total = total + retrieval;
        }

        // Calculate average retrieval time
        double average = (double) total / n;

        // Display results
        System.out.println("\nOptimal Order: " + Arrays.toString(length));
        System.out.println("Total Retrieval Time: " + total);
        System.out.println("Average Retrieval Time: " + average);

        sc.close();
    }
}
