package entity;

public class Student extends Person {

    private double mark;

    public Student() {
    }

    public Student(String rollNumber, double mark, String name, boolean gender) {
        super(name, rollNumber, gender);
        this.mark = mark;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String display() {
        String s = super.getName() + " - " + (super.isGender() == false ? "female" : "male") + " - " + super.getRollNumber() + " - " + mark;
        return s;
    }

}
