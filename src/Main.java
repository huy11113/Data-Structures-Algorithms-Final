import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo StudentManagement với dung lượng Stack cố định, ví dụ 100
        StudentManagement management = new StudentManagement(100);

        int choice;
        do {
            // Menu choices
            System.out.println("\n---- Student Management Menu ----");
            System.out.println("1. Add Students");
            System.out.println("2. Add Random Students");
            System.out.println("3. Edit Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Sort Students by Marks (Bubble Sort)");
            System.out.println("7. Sort Students by Marks (Selection Sort)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice != 0) {

            }

            switch (choice) {
                case 1:
                    // Add multiple students
                    System.out.print("Enter the number of students you want to add: ");
                    int numberOfStudents = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    for (int i = 1; i <= numberOfStudents; i++) {
                        System.out.println("Enter details for student " + i + ":");
                        System.out.print("Enter student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student marks: ");
                        double marks = scanner.nextDouble();
                        management.addStudent(new Student(id, name, marks));
                    }
                    break;
                case 2:
                    // Add random students
                    System.out.print("Enter the number of random students to add: ");
                    int randomCount = scanner.nextInt();
                    management.addRandomStudents(randomCount);
                    break;

                case 3:
                    // Edit student details
                    System.out.print("Enter student ID to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new student name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new student marks: ");
                    double newMarks = scanner.nextDouble();
                    management.editStudent(editId, newName, newMarks);
                    break;

                case 4:
                    // Delete a student
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    management.deleteStudent(deleteId);
                    break;

                case 5:
                    // Search for a student by ID
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    Student foundStudent = management.searchStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;

                case 6:
                    // Sort students by marks using Bubble Sort and measure time
                    long bubbleStartTime = System.nanoTime();
                    management.sortStudentsByMarksBubbleSort();
                    long bubbleEndTime = System.nanoTime();
                    System.out.println("Bubble Sort Time: " + (bubbleEndTime - bubbleStartTime) + " nanoseconds");
                    break;

                case 7:
                    // Sort students by marks using Selection Sort and measure time
                    long selectionStartTime = System.nanoTime();
                    management.sortStudentsByMarksQuickSort();
                    long selectionEndTime = System.nanoTime();
                    System.out.println("Selection Sort Time: " + (selectionEndTime - selectionStartTime) + " nanoseconds");
                    break;

                case 0:
                    // Exit program
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}

