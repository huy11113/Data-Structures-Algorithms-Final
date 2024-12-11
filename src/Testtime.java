import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Testtime {

    public static void main(String[] args) {
        Random rand = new Random();
        int numStudents = 5000;  // You can change this to test with more or fewer students
        List<Student> students = new ArrayList<>();

        // Generate random students
        for (int i = 0; i < numStudents; i++) {
            students.add(new Student(i, "Student" + i, rand.nextDouble() * 100));
        }

        // Clone the list for both sorting algorithms
        List<Student> bubbleSortList = new ArrayList<>(students);
        List<Student> selectionSortList = new ArrayList<>(students);

        // Measure time for Bubble Sort
        long startTime = System.nanoTime();
        bubbleSort(bubbleSortList);
        long endTime = System.nanoTime();
        long bubbleSortTime = endTime - startTime;

        // Measure time for Selection Sort
        startTime = System.nanoTime();
        selectionSort(selectionSortList);
        endTime = System.nanoTime();
        long selectionSortTime = endTime - startTime;

        // Print out the results
        System.out.println("Bubble Sort time: " + bubbleSortTime + " nanoseconds");
        System.out.println("Selection Sort time: " + selectionSortTime + " nanoseconds");
    }

    // Bubble Sort implementation
    public static void bubbleSort(List<Student> students) {
        List<Student> bubbleList = new ArrayList<>(students); // Copy the list
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }

    // Selection Sort implementation
    public static void selectionSort(List<Student> students) {
        List<Student> selectionList = new ArrayList<>(students);
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students.get(j).getMarks() < students.get(minIndex).getMarks()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Student temp = students.get(i);
                students.set(i, students.get(minIndex));
                students.set(minIndex, temp);
            }
        }
    }
}
