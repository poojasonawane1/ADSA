import java.util.Scanner;

public class HashFunction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Table Size: ");
        int tableSize = sc.nextInt();

        System.out.print("Enter Key: ");
        int key = sc.nextInt();

        int hashIndex = key % tableSize;

        System.out.println("Hash Index = " + hashIndex);

        sc.close();
    }
}
