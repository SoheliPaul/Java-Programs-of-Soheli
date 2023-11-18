import java.util.Scanner;

public class Performance {
    int marks[];
    int freq;

    Performance() {
        marks = new int[10];
    }

    void readMarks() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the marks of 10 students:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Student " + (i + 1) + ": ");

            // Keep prompting for input until a valid mark is entered
            while (true) {
                int entered = sc.nextInt();
                
                if (entered >= 0 && entered <= 100) {
                    marks[i] = entered;
                    break; // Exit the loop if the mark is valid
                } else {
                    System.out.println("Invalid input. Please enter a mark between 0 and 100.");
                }
            }
        }
    }

    int highestMark() {
        int max = marks[0];
        for (int i = 0; i < marks.length; i++) {
            if (max < marks[i]) {
                max = marks[i];
            }
        }
        return max;
    }

    int leastMark() {
        int min = marks[0];
        for (int i = 0; i < marks.length; i++) {
            if (min > marks[i]) {
                min = marks[i];
            }
        }
        return min;
    }

    int getMode() {
        int maxVal = 0, count = 0, maxCount = 0;
        for (int i = 0; i < 10; i++) {
            count = 0;
            for (int j = 0; j < 10; j++) {
                if (marks[i] == marks[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxVal = marks[i];
            }
        }
        freq = maxCount;
        return maxVal;
    }

    int getFreqAtMode() {
        return freq;
    }

    public void display() {
        System.out.println("Highest Mark: " + highestMark());
        System.out.println("Least Mark: " + leastMark());
        System.out.println("Mode: " + getMode());
        System.out.println("Mode Frequency: " + getFreqAtMode());
    }

    public static void main(String[] args) {
        Performance obj1 = new Performance();
        obj1.readMarks();
        obj1.display();
    }
}