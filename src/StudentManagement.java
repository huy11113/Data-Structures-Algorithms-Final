import java.util.Random;

class StudentManagement {
    private StudentStack students;

    public StudentManagement(int capacity) {
        this.students = new StudentStack(capacity);
    }

    // Thêm sinh viên mới
    public void addStudent(Student student) {
        students.push(student);
        System.out.println("Student added: " + student);
    }

    // Thêm sinh viên ngẫu nhiên
    public void addRandomStudents(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int id = random.nextInt(1000) + 1; // ID ngẫu nhiên (1-1000)
            String name = "Student" + id; // Tên ngẫu nhiên
            double marks = Math.round((random.nextDouble() * 10) * 10.0) / 10.0; // Điểm ngẫu nhiên (0.0 - 10.0)
            addStudent(new Student(id, name, marks));
        }
        System.out.println(count + " random students added.");
    }

    // Chỉnh sửa thông tin sinh viên
    public void editStudent(int id, String newName, double newMarks) {
        Student student = searchStudentById(id);
        if (student != null) {
            student.setName(newName);
            student.setMarks(newMarks);
            System.out.println("Student updated: " + student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Xóa sinh viên theo ID
    public void deleteStudent(int id) {
        Student student = searchStudentById(id);
        if (student != null) {
            StudentStack tempStack = new StudentStack(students.size());
            while (!students.isEmpty()) {
                Student popped = students.pop();
                if (popped.getId() != id) {
                    tempStack.push(popped);
                }
            }
            // Đẩy lại các sinh viên còn lại vào Stack ban đầu
            while (!tempStack.isEmpty()) {
                students.push(tempStack.pop());
            }
            System.out.println("Student deleted: " + student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }


    // Tìm sinh viên theo ID
    public Student searchStudentById(int id) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }



    // Sắp xếp sinh viên theo điểm sử dụng Bubble Sort
    public void sortStudentsByMarksBubbleSort() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    // Hoán đổi sinh viên
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        System.out.println("Students sorted by marks using Bubble Sort.");
    }

    // Sắp xếp sinh viên theo điểm sử dụng Quick Sort
    public void sortStudentsByMarksQuickSort() {
        quickSort(0, students.size() - 1);
        System.out.println("Students sorted by marks using Quick Sort.");
    }

    // Phương thức Quick Sort
    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);  // Sắp xếp phần bên trái của pivot
            quickSort(pivotIndex + 1, high); // Sắp xếp phần bên phải của pivot
        }
    }

    // Phương thức partition cho Quick Sort
    private int partition(int low, int high) {
        double pivot = students.get(high).getMarks();  // Chọn phần tử cuối làm pivot
        int i = low - 1;  // Chỉ số của phần tử nhỏ hơn pivot

        for (int j = low; j < high; j++) {
            if (students.get(j).getMarks() <= pivot) {
                i++;
                // Hoán đổi students[i] và students[j]
                Student temp = students.get(i);
                students.set(i, students.get(j));
                students.set(j, temp);
            }
        }

        // Hoán đổi students[i + 1] và students[high] (pivot)
        Student temp = students.get(i + 1);
        students.set(i + 1, students.get(high));
        students.set(high, temp);

        return i + 1;  // Trả về vị trí của pivot
    }
    // Hiển thị tất cả sinh viên
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Students in stack:");
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i));
            }
        }
    }
}
