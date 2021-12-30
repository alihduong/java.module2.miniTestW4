import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManage {
    public static final String PATH_NAME = ("src/DatabaseStudent.csv");
    ArrayList<Student> studentList = new ArrayList<>();
    Student[] students;
    Scanner scanner = new Scanner(System.in);

    public ArrayList<Student> displayAll (){
        return  studentList;
    }

    public void displayStudentById(int id){
        for (Student st: studentList){
            if (st.getId() == id){
                System.out.printf(" Id: %s \n Name: %s \n Age: %s \n Điểm Toán %s \n Điểm Lý: %s \n Điểm Hoá: %s \n Điểm Trung bình: %s%n",
                        st.getId(), st.getName(), st.getAge(), st.getMathScores(), st.getPhysicalScores(), st.getChemicalScores(), st.getAverage());
                break;
            }
        }
    }

    public void addStudent(){
        System.out.println("Nhập mã sinh viên: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Nhập tên sinh viên: ");
        String name =  scanner.nextLine();
        System.out.println("Nhập tuổi sinh viên: ");
        int age = scanner.nextInt();
        System.out.println("Nhập Điểm toán: ");
        double mathScores_ = scanner.nextDouble();
        System.out.println("Nhập Điểm lý: ");
        double physicsScores_ = scanner.nextDouble();
        System.out.println("Nhập Điểm hoá: ");
        double chemicalScores_ =scanner.nextDouble();
        Student student =new Student(id, name, age, mathScores_, physicsScores_,chemicalScores_);
        System.out.println(student);
        studentList.add(student);
    }

    public void editStudentById(int id){
        Student student = null;
        for (Student st : studentList){
            if (st.getId() == id){
                student = st;
            }
            if (student != null){
                int index = studentList.indexOf(student);
                System.out.println("Nhập tên sinh viên mới: ");
                String newName = scanner.next();
                student.setName(newName);

                System.out.println("Nhập tuổi sinh viên mới: ");
                int newAge= scanner.nextInt();
                scanner.nextLine();
                student.setAge(newAge);

                System.out.println("Nhập điểm toán mới: ");
                double newMathSocer = scanner.nextDouble();
                student.setMathScores(newMathSocer);

                System.out.println("Nhập điểm lý mới: ");
                double newPhysicalScore = scanner.nextDouble();
                student.setMathScores(newPhysicalScore);

                System.out.println("Nhập điểm hoá mới: ");
                double newChemicalScore = scanner.nextDouble();
                student.setMathScores(newChemicalScore);

                System.out.printf(" Id: %s \n Name: %s \n Age: %s \n Điểm Toán %s \n Điểm Lý: %s \n Điểm Hoá: %s \n Điểm Trung bình: %s%n",
                        st.getId(), st.getName(), st.getAge(), st.getMathScores(), st.getPhysicalScores(), st.getChemicalScores(), st.getAverage());
            }
        }
    }

    public void deleteStudentById(int id){
        Student student = null;
        for (Student st : studentList){
            if (st.getId() == id){
                student = st;
            }
        }
        studentList.remove(student);
        System.out.println(toString());
    }

    public void arrangeIncreasing() {
        for (int i = 0; i < studentList.size(); i++) {
            for (int j = 0; j < studentList.size(); j++) {
                if (studentList.get(i).getAverage() > studentList.get(j).getAverage()){
                    Student temp = studentList.get(i);
                    studentList.set(i,studentList.get(j));
                    studentList.set(j,temp);
                }
            }
        }
    }

    public void arrangeDecreasing() {
        for (int i = 0; i < studentList.size(); i++) {
            for (int j = 0; j < studentList.size(); j++) {
                if (studentList.get(i).getAverage() < studentList.get(j).getAverage()){
                    Student temp = studentList.get(i);
                    studentList.set(i,studentList.get(j));
                    studentList.set(j,temp);
                }
            }
        }
    }

    public void writeCSV(ArrayList<Student> studentList) {
        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_NAME));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_NAME));
            for (Student student : studentList) {
                bufferedWriter.write(student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getMathScores() + "," + student.getPhysicalScores() + "," + student.getChemicalScores() + "," + student.getAverage());
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
            System.out.println("Write Success");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Write Fail");
        }
    }

    public ArrayList<Student> readCSV() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_NAME));
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                String[] studentInfo = line.split(",");
                studentArrayList.add(new Student(Integer.parseInt(studentInfo[0]),studentInfo[1],Integer.parseInt(studentInfo[2]),Double.parseDouble(studentInfo[3]),Double.parseDouble(studentInfo[4]),Double.parseDouble(studentInfo[5])));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return studentArrayList;
    }
}
