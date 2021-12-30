public class Student extends Person {
    private double mathScores;
    private double chemicalScores;
    private double physicalScores;

    public Student(long id, String name, int age, double mathScores, double chemicalScores, double physicalScores) {
        super(id, name, age);
        this.mathScores = mathScores;
        this.chemicalScores = chemicalScores;
        this.physicalScores = physicalScores;
    }

    public double getMathScores() {
        return mathScores;
    }

    public void setMathScores(double mathScores) {
        this.mathScores = mathScores;
    }

    public double getChemicalScores() {
        return chemicalScores;
    }

    public void setChemicalScores(double chemicalScores) {
        this.chemicalScores = chemicalScores;
    }

    public double getPhysicalScores() {
        return physicalScores;
    }

    public void setPhysicalScores(double physicalScores) {
        this.physicalScores = physicalScores;
    }

    public double getAverage() {
        return (chemicalScores + mathScores + physicalScores) / 3;
    }

    @Override
    public String toString() {
        return "Student{" +  "mathScores=" + mathScores + ", chemicalScores=" + chemicalScores +
                ", physicalScores=" + physicalScores + "Average= "+ this.getAverage()+
                '}';
    }
}
