import java.util.Scanner;

public class Program4 {
    static int[] arr;

    public static void frequency(int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Find the minimum and maximum values in the array
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        // Calculate the range to create the frequency array
        int range = max - min + 1;
        int[] frequency = new int[range];

        // Calculate frequencies using indexing by value
        for (int num : arr) {
            frequency[num - min]++;
        }

        // Find the K numbers with the highest frequencies
        int count = 0;
        while (count < k) {
            int maxFreq = 0;
            int maxIndex = 0;

            // Find the maximum frequency and its index
            for (int i = 0; i < range; i++) {
                if (frequency[i] > maxFreq) {
                    maxFreq = frequency[i];
                    maxIndex = i;
                }
            }

            // If the maxFreq is 0, no more numbers with non-zero frequency
            if (maxFreq == 0) {
                break;
            }

            // Output the number corresponding to the index (adjusted by min)
            System.out.print((maxIndex + min) + " ");

            // Set the frequency to 0 to exclude it from the next search
            frequency[maxIndex] = 0;
            count++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the array size as user input
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        arr = new int[size];

        // Populate the array elements from user input
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Get the value of k as user input
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        frequency(k); // Call the frequency method with user-provided k value
    }
}