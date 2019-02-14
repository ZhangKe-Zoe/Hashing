/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apple
 */
public class Students<Key, Value> extends HashTable {

    private ArrayList<Student> students;

    public Students() {
        super(1000);
        students = new ArrayList<>();

    }

    public boolean addStudent(Student student) {
        
        boolean isAdded = !isReapeted(student);
        if (isAdded) {
            students.add(student);
            put(student.getMatriculationNumber(), student);
        }
        return isAdded;
    }

    public Student geStudent(int MatriculationNumber) {
        return (Student) get(MatriculationNumber);
    }
    
    public ArrayList<Student> getStudentTable(){
        return students;
    }

    public boolean isReapeted(Student student) {
        boolean isReapeted = false;
        for (Student s : students) {
            if (student.equals(s)) {
                isReapeted = true;
                break;
            }
        }
        return isReapeted;
    }

}
