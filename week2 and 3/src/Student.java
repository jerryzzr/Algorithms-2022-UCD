public class Student {
    String name;
    String studentNumber;

    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "Name: <"+name+">\n"+"Student Number: <"+studentNumber+">";
    }
}
