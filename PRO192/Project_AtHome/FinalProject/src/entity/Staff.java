package entity;

public class Staff extends Person {

    private long salary;

    public Staff() {
    }

    public Staff(String rollNumber, long salary, String name, boolean gender) {
        super(name, rollNumber, gender);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String display() {
        String s = super.getName() + " - " + (super.isGender() == true ? "male" : "female") + " - " + super.getRollNumber() + " - " + salary;
        return s;
    }

}
