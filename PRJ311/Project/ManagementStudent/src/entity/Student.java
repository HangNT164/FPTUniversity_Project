/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author HangNT
 */
public class Student {

    private int id;
    private String rollNumber;
    private String fullName;
    private boolean gender;
    private String email;
    private String phoneNumber;
    private String address;

    public Student() {
    }

    public Student(String rollNumber, String fullName, boolean gender, String email, String phoneNumber, String address) {
        this.rollNumber = rollNumber;
        this.fullName = fullName;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Student(int id, String rollNumber, String fullName, boolean gender, String email, String phoneNumber, String address) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.fullName = fullName;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.getRollNumber(), this.getFullName(),
            this.gender == true ? "Male" : "Female",
            this.email, this.phoneNumber, this.address,};
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", rollNumber=" + rollNumber + ", fullName=" + fullName + ", gender=" + gender + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + '}';
    }
    
}
