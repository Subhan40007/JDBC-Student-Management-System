package aze.company.process;

import aze.company.connection.DBConnection;
import aze.company.entity.Student;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DBProcess {
    private static PreparedStatement preparedStatement = null;

    private static Connection connection = DBConnection.getConnection();

    private static ResultSet resultSet = null;

    public static void createStudentTable() {
        try {
            String querry = "CREATE TABLE student" +
                    "(studentId INT PRIMARY KEY NOT NULL," +
                    " name VARCHAR(255)," +
                    " surname VARCHAR(255)," +
                    "birthDate INT," +
                    " cardNumber VARCHAR(30))";
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.execute();
            System.out.println("Table Has Created Succesfully!");
        } catch (SQLException e) {
            System.out.println("Table Hasn't Created Succesfully!");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        DBConnection.closeConnection();
    }

    public static void insertStudent(List<Student> students) {
        String query = "INSERT INTO student (studentId, name, surname, birthDate, cardNumber) VALUES (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            for (Student student : students){
                preparedStatement.setInt(1, student.getStudentId());
                preparedStatement.setString(2, student.getName());
                preparedStatement.setString(3, student.getSurname());
                preparedStatement.setInt(4, student.getBirthOfDate());
                preparedStatement.setString(5, student.getCardNumber());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            System.out.println("Insert is successful!");
        } catch (SQLException e) {
            System.out.println("Insert isn't successful!");
        }
    }

    public static void updateStudent(Student student) {
        String query = "UPDATE student SET name = ?, surname = ?, birthDate = ?, cardNumber = ? WHERE studentId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setInt(3, student.getBirthOfDate());
            preparedStatement.setString(4, student.getCardNumber());
            preparedStatement.setInt(5, student.getStudentId());
            preparedStatement.executeUpdate();

            System.out.println("Student update is Succesful");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
    }

    public static void deleteStudent(Integer id) {
        String query = "DELETE from student WHERE studentId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Delete Data is Succesful?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
    }

    public static void findStudentById() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Input the Student ID: ");
            int studentId = input.nextInt();
            String query = "SELECT * FROM student WHERE studentId = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                Integer birthDate = resultSet.getInt(4);
                String cardNumber = resultSet.getString(5);
                System.out.printf("Id: %d, Name: %s, Surname: %s, BirthDate: %d, CardNumber: %s.", id, name, surname, birthDate, cardNumber);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InputMismatchException e) {
            System.out.println("Input is incorrect!");
        }
    }

    public static void findStudenLikeName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the Letter: ");
        String letter = input.next();
        String query = "SELECT * FROM student WHERE name LIKE '" + letter + "%'";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                System.out.println(name + " " + surname);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}