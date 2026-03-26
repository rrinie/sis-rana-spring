package com.sis.oop;

import com.sis.EnhanceUserExperience.Colors;
import com.sis.data.Student;
import java.util.Scanner;

public class StudentInformationSystemV3 {

    public static Student createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Colors.RED + " -----student adding system---- \n" + Colors.RESET + "Please enter the ID.");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the name");
        String name = scanner.nextLine();
        System.out.println("Please enter the age");
        int age = scanner.nextInt();
        scanner.nextLine();
        Student student = new Student(age, name, id);
        return student;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        int choice = 0;
        System.out.println(Colors.RED + "Welcome to SIS. Please proceed accordingly.");
        do {
            StudentManager.printMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Student student = createStudent();
                    studentManager.addStudent(student);
                    System.out.println(Colors.RED + "------" + student.getName() + " was added---------" + Colors.RESET);
                    break;
                case 2:
                    if (studentManager.isStudentListEmpty()) {
                        System.out.println(Colors.RED + "No students were found to update." + Colors.RESET);
                        break;
                    }
                    System.out.println(Colors.RED + "-----student update system----- \n" + Colors.RESET + "Write the ID you want to update");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    com.sis.data.Student updateThis = studentManager.updateStudent(id);
                    if (updateThis != null) {
                        System.out.println(Colors.RED + "------ ID " + id + " was successfully updated ---------" + Colors.RESET);
                    }
                    break;

                case 3:
                    if (!studentManager.isStudentListEmpty()) {
                        System.out.println("Choose the id you want to delete");
                        int idToDelete = scanner.nextInt();
                        scanner.nextLine();
                        studentManager.deleteStudent(idToDelete);
                    } else {
                        System.out.println(Colors.RED + "No students were found to delete." + Colors.RESET);
                    }
                    break;
                case 4:
                    studentManager.listStudents();
                    break;
                case 5:
                    StudentManager.exitSystem();
                    break;
                default:
                    System.out.println(Colors.RED + "Please press a valid number." + Colors.RESET);
            }
        } while (choice != 5);

    }


}
