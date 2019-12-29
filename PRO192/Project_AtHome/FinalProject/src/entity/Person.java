package entity;

public class Person //implements Comparable<Person>
{

    private String name;
    private String rollNumber;
    private boolean gender;

    public Person() {
    }

    public Person(String name, String rollNumber, boolean gender) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String display() {
        String s=name+" - "+rollNumber+" - "+gender;
        return s;
    }

//    @Override
//    public int compareTo(Person o) {
//        return this.name.compareTo(o.getName());
//    }
//    
}
