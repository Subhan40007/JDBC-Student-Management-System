package aze.company.entity;

public class Student {
    private Integer studentId;
    private String name;
    private String surname;
    private Integer birthOfDate;
    private String cardNumber;

    public Student(Integer studentId, String name, String surname, Integer birthOfDate, String cardNumber) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.birthOfDate = birthOfDate;
        this.cardNumber = cardNumber;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Integer birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


}
