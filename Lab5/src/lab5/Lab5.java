/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apple
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //task 1.a put the speech of Cicero in a String array
        System.out.println("Task 1. HashTables and Collisions\n");
        String path = "//Users//apple//Desktop//AD//labs//speech.txt";
        String delimiter = " ";
        String[] speech = TextReader.readFromFile(path, delimiter);

        //Build a word index with the HashTable class
        //task1.d Use M’s = {100, 250, 500, 750, 1000, 10000, 100000} and count the collisions.
        int[] M = {100, 250, 500, 750, 1000, 10000, 100000};
        int[] collisions = new int[M.length];

        for (int i = 0; i < M.length; i++) {
            int collision = 0;
            HashTable<String, Integer> hashTable = new HashTable(M[i]);

            for (int j = 0; j < speech.length; j++) {

                if (hashTable.isColliding(speech[j])) {
                    collision += 1;
                }
                hashTable.put(speech[j], j);
            }
            System.out.println("The collisions with M=" + M[i] + ": " + collision);
            collisions[i] = collision;
        }

        //Task 2. Hashing Objects
        System.out.println("\n\nTask 2. Hashing Objects\n");
        Students<Integer, Student> students = new Students();
        Scanner scanner = new Scanner(System.in);
        Student student;
        int MatriculationNumber;

        int function = 0;

        System.out.println("Create a new student table:");
        System.out.println("\nFunctions: \n1: add a new student\n2: search student's information by the Matriculation Number\n3: show student table\n4: quit the system");

        while (function != 4) {
            System.out.println("\nPlease choose the function(perss: 1/2/3/4):");
            function = scanner.nextInt();
            scanner.nextLine();
            switch (function) {
                case 1: {
                    student = new Student();
                    MatriculationNumber = student.getMatriculationNumber();

                    System.out.println("\nCreate a new student with the Matriculation Number:" + MatriculationNumber + "\nPlease input the student's information:");

                    System.out.print("Name: ");
                    student.setName(scanner.nextLine());
                    System.out.print("Surname: ");
                    student.setSurname(scanner.nextLine());
                    System.out.print("Street: ");
                    student.setStreet(scanner.nextLine());
                    System.out.print("ZIP: ");
                    student.setZIP(scanner.nextInt());
                    System.out.print("City: ");
                    student.setCity(scanner.next());

                    if (!students.addStudent(student)) {
                        System.out.println("Repeated student information, fail to add");
                    } else {
                        System.out.println("Operate successfully!");
                    }
                    break;
                }
                case 2: {
                    System.out.println("\nPlease input the student's MatriculationNumber:");
                    MatriculationNumber = scanner.nextInt();
                    student = students.geStudent(MatriculationNumber);

                    System.out.println("\nresult:");
                    if (student != null) {
                        System.out.println("Name: " + student.getName());
                        System.out.println("Surname: " + student.getSurname());
                        System.out.println("Street: " + student.getStreet());
                        System.out.println("ZIP: " + student.getZIP());
                        System.out.println("City: " + student.getCity());
                    } else {
                        System.out.println("No information about this student");
                    }
                    break;

                }
                case 3: {
                    for (Student s : students.getStudentTable()) {
                        
                        System.out.println("\nMatriculationNumber: " + s.getMatriculationNumber());
                        System.out.println("Name: " + s.getName());
                        System.out.println("Surname: " + s.getSurname());
                        System.out.println("Street: " + s.getStreet());
                        System.out.println("ZIP: " + s.getZIP());
                        System.out.println("City: " + s.getCity());
                    }
                }
                case 4:
                    break;
                default: {
                    System.out.println("Wrong input! Try again!(1/2/3/4 expected)");
                    break;
                }
            }

        }
    }

}
