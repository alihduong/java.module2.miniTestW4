import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        StudentManage studentManage = new StudentManage();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {

            System.out.println("-----<Tính năng>-----");
            System.out.println("1. Thêm mới sinh viên.");
            System.out.println("2. Hiển thị tất sinh viên.");
            System.out.println("3. Hiển thị sinh viên theo id.");
            System.out.println("4. Sửa thông tin sinh viên.");
            System.out.println("5. Xoá sinh viên theo id.");
            System.out.println("6. Hiện thị list sinh viên được sắp xếp.");
            System.out.println("7. Hiện sinh viên có điểm trung bình cao nhất.");
            System.out.println("8. Write file CSV");
            System.out.println("9. Read file CSV");
            System.out.println("0. Exit ^^");
            System.out.println("-----<Vui lòng chọn tính năng>-----");
            choice = scanner.nextInt();
            try {
                switch (choice){
                    case 1:
                        studentManage.addStudent();
                        break;
                    case 2:
                        studentManage.displayAll();
                        break;
                    case 3:
                        System.out.println("Nhập id sinh viên: ");
                        int id = scanner.nextInt();
                        studentManage.displayStudentById(id);
                        break;
                    case 4:
                        System.out.println("Nhập id sinh viên muốn sửa: ");
                        int idEdit = scanner.nextInt();
                        studentManage.editStudentById(idEdit);
                        break;
                    case 5:
                        System.out.println("Nhập id sinh viên muốn xoá: ");
                        int idDelete = scanner.nextInt();
                        studentManage.deleteStudentById(idDelete);
                    case 6:
                        int choices = scanner.nextInt();
                        System.out.println("1. Xắp xếp tăng dần");
                        System.out.println("2. Xắp xếp giảm dần");
                        switch (choices){
                            case 1:
                                studentManage.arrangeIncreasing();
                                break;
                            case 2:
                                studentManage.arrangeDecreasing();
                                break;
                        }
                        break;
                    case 7:
                        break;
                    case 8:
                        studentManage.writeCSV(studentManage.displayAll());
                        break;
                    case 9:
                        studentManage.readCSV().forEach(System.out::println);
                    case 0:
                        System.err.println("Ôi bạn ơiiiii !!!!");
                        break;

                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        }while (choice != 0);
    }
}
