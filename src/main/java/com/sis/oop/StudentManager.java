package com.sis.oop;

import com.sis.EnhanceUserExperience.Colors;
import com.sis.data.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    List<Student> studentList = new ArrayList<>();
    public static void printMenu() {
        System.out.println(Colors.BLUE + "[1]" + Colors.RESET + " " + Colors.YELLOW + "Add new student" + Colors.RESET);
        System.out.println(Colors.BLUE + "[2]" + Colors.RESET + " " + Colors.YELLOW + "Update student" + Colors.RESET);
        System.out.println(Colors.BLUE + "[3]" + Colors.RESET + " " + Colors.YELLOW + "Delete student record" + Colors.RESET);
        System.out.println(Colors.BLUE + "[4]" + Colors.RESET + " " + Colors.YELLOW + "List the students" + Colors.RESET);
        System.out.println(Colors.BLUE + "[5]" + Colors.RESET + " " + Colors.YELLOW + "Exit" + Colors.RESET);
    }
    public Student updateStudent(int id) {
        String newName = "X";
        int newAge = 0;
        Scanner scanner = new Scanner(System.in);
        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println(Colors.RED + "No student match found to update." + Colors.RESET);
            return null;
        } else {
            System.out.println("To update the name press 1, to update the age press 2");
            int updateChoice = scanner.nextInt();
            scanner.nextLine();

            if (updateChoice == 1) {
                System.out.println("Please enter the new name.");
                newName = scanner.nextLine();

            } else if (updateChoice == 2) {
                System.out.println("Please enter the new age");
                newAge = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println(Colors.RED + "Please enter a valid number." + Colors.RESET);
                //It should repeat itself from here
            }
            if (updateChoice == 2) {
                studentList.get(index).setAge(newAge);
            } else if (updateChoice == 1) {
                studentList.get(index).setName(newName);
            }
            return studentList.get(index);
        }


    }
    public int findStudentIndex(int studentId) {
        int index = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == studentId) {
                index = i;
            }
        }
        return index;
    }
    public static void exitSystem() {
        System.out.println("Exitting...");
        System.exit(0);
    }
public boolean isStudentListEmpty(){
    if (studentList.size() != 0) {
        return false;
    }else {
        return true;
    }
}
    public  void deleteStudent(int id) {
        int indexToDelete = findStudentIndex(id);
        if (indexToDelete != -1) {
            System.out.println("Deleted: \n  " + studentList.get(indexToDelete).getName());
            studentList.remove(indexToDelete);
        } else {
            System.out.println("No id match");

        }
    }
    public void addStudent(Student student) {
      studentList.add(student);
    }
    public void listStudents(){
        if (studentList.size() != 0) {
            System.out.println("ID      NAME        AGE\n" +
                    "-----------------------");
            for (Student s : studentList) {
                System.out.println(s.showOnlyDetails());
            }
        } else {
            System.out.println(Colors.RED + "No students were found." + Colors.RESET);
        }
    }
}
