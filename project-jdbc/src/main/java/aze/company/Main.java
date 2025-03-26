package aze.company;

import aze.company.connection.DBConnection;
import aze.company.entity.Student;
import aze.company.process.DBProcess;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1,"Subhan","Velili",2007,"4169738800998877");
        Student student2 = new Student(2,"AAAA","A$A$",2001,"4169738800128877");
        Student student3 = new Student(3,"BBBB","B$B$",2000,"4169738800998437");
        students.add(student1);
        students.add(student2);
        students.add(student3);
//        DBConnection.getConnection();
//        DBConnection.closeConnection();
//        DBProcess.createStudentTable();
//        DBProcess.insertStudent(students);
    }
}