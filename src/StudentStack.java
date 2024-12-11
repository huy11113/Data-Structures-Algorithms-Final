class StudentStack {
    private Student[] stack;  // Mảng lưu trữ các sinh viên
    private int top;          // Chỉ số của phần tử đỉnh stack
    private int size;         // Kích thước hiện tại của stack

    // Constructor
    public StudentStack(int capacity) {
        stack = new Student[capacity];  // Khởi tạo mảng với dung lượng cố định
        size = 0;  // Ban đầu stack trống
        top = -1;   // Không có phần tử nào trong stack
    }

    // Push sinh viên vào stack
    public void push(Student student) {
        if (size == stack.length) {
            System.out.println("Stack Overflow! Không thể thêm sinh viên.");
            return;
        }
        stack[++top] = student;  // Đặt sinh viên vào đỉnh stack và tăng top
        size++;
    }

    // Pop sinh viên khỏi stack
    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Không có sinh viên nào để loại bỏ.");
            return null;  // Trả về null nếu stack rỗng
        }
        Student student = stack[top--];  // Lấy sinh viên ở đỉnh và giảm top
        size--;
        return student;
    }

    // Xem sinh viên ở đỉnh stack
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;  // Trả về null nếu stack rỗng
        }
        return stack[top];  // Trả về sinh viên ở đỉnh stack
    }

    // Kiểm tra stack có rỗng không
    public boolean isEmpty() {
        return size == 0;
    }

    // Hiển thị các sinh viên trong stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("Sinh viên trong Stack:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    // Trả về kích thước hiện tại của stack
    public int size() {
        return size;
    }

    // Lấy sinh viên ở vị trí chỉ định
    public Student get(int index) {
        if (index >= 0 && index < size) {
            return stack[index];
        }
        return null;
    }

    // Cập nhật sinh viên ở vị trí chỉ định
    public void set(int index, Student student) {
        if (index >= 0 && index < size) {
            stack[index] = student;
        }
    }
}
